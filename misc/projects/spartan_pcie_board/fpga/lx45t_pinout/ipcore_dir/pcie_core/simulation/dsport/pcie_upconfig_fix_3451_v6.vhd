-------------------------------------------------------------------------------
--
-- (c) Copyright 2009 Xilinx, Inc. All rights reserved.
--
-- This file contains confidential and proprietary information
-- of Xilinx, Inc. and is protected under U.S. and
-- international copyright and other intellectual property
-- laws.
--
-- DISCLAIMER
-- This disclaimer is not a license and does not grant any
-- rights to the materials distributed herewith. Except as
-- otherwise provided in a valid license issued to you by
-- Xilinx, and to the maximum extent permitted by applicable
-- law: (1) THESE MATERIALS ARE MADE AVAILABLE "AS IS" AND
-- WITH ALL FAULTS, AND XILINX HEREBY DISCLAIMS ALL WARRANTIES
-- AND CONDITIONS, EXPRESS, IMPLIED, OR STATUTORY, INCLUDING
-- BUT NOT LIMITED TO WARRANTIES OF MERCHANTABILITY, NON-
-- INFRINGEMENT, OR FITNESS FOR ANY PARTICULAR PURPOSE; and
-- (2) Xilinx shall not be liable (whether in contract or tort,
-- including negligence, or under any other theory of
-- liability) for any loss or damage of any kind or nature
-- related to, arising under or in connection with these
-- materials, including for any direct, or any indirect,
-- special, incidental, or consequential loss or damage
-- (including loss of data, profits, goodwill, or any type of
-- loss or damage suffered as a result of any action brought
-- by a third party) even if such damage or loss was
-- reasonably foreseeable or Xilinx had been advised of the
-- possibility of the same.
--
-- CRITICAL APPLICATIONS
-- Xilinx products are not designed or intended to be fail-
-- safe, or for use in any application requiring fail-safe
-- performance, such as life-support or safety devices or
-- systems, Class III medical devices, nuclear facilities,
-- applications related to the deployment of airbags, or any
-- other applications that could lead to death, personal
-- injury, or severe property or environmental damage
-- (individually and collectively, "Critical
-- Applications"). Customer assumes the sole risk and
-- liability of any use of Xilinx products in Critical
-- Applications, subject only to applicable laws and
-- regulations governing limitations on product liability.
--
-- THIS COPYRIGHT NOTICE AND DISCLAIMER MUST BE RETAINED AS
-- PART OF THIS FILE AT ALL TIMES.
--
-------------------------------------------------------------------------------
-- Project    : Spartan-6 Integrated Block for PCI Express
-- File       : pcie_upconfig_fix_3451_v6.vhd
-- Description: Virtex6 Workaround for Root Port Upconfigurability Bug
--
-------------------------------------------------------------------------------

library ieee;
   use ieee.std_logic_1164.all;
   use ieee.std_logic_unsigned.all;

entity pcie_upconfig_fix_3451_v6 is
   generic (

      UPSTREAM_FACING                              : boolean := TRUE;
      PL_FAST_TRAIN                                : boolean := FALSE;
      LINK_CAP_MAX_LINK_WIDTH                      : bit_vector := X"08"
   );
   port (
      pipe_clk                                     : in std_logic;
      pl_phy_lnkup_n                               : in std_logic;
      pl_ltssm_state                               : in std_logic_vector(5 downto 0);
      pl_sel_lnk_rate                              : in std_logic;
      pl_directed_link_change                      : in std_logic_vector(1 downto 0);
      cfg_link_status_negotiated_width             : in std_logic_vector(3 downto 0);
      filter_pipe                                  : out std_logic
   );
end pcie_upconfig_fix_3451_v6;

architecture v6_pcie of pcie_upconfig_fix_3451_v6 is

   constant TCQ                                    : integer := 1;
   signal reg_filter_pipe                          : std_logic;

   signal reg_prev_pl_ltssm_state                  : std_logic_vector(5 downto 0);
   signal prev_pl_ltssm_state                      : std_logic_vector(5 downto 0);

   signal reg_tsx_counter                          : std_logic_vector(15 downto 0);
   signal tsx_counter                              : std_logic_vector(15 downto 0);

   signal cap_link_width                           : std_logic_vector(5 downto 0);

   -- X-HDL generated signals

   signal v6pcie1                                  : std_logic_vector(15 downto 0);
   signal v6pcie2                                  : std_logic_vector(15 downto 0);

   -- Declare intermediate signals for referenced outputs
   signal filter_pipe_v6pcie0                      : std_logic;

begin
   -- Drive referenced outputs
   filter_pipe <= filter_pipe_v6pcie0;

   -- Corrupting all Tsx on all lanes as soon as we do R.RC->R.RI transition to allow time for
   -- the core to see the TS1s on all the lanes being configured at the same time
   -- R.RI has a 2ms timeout.Corrupting tsxs for ~1/4 of that time
   -- 225 (00E1 Hex) pipe_clk cycles-sim_fast_train
   -- 60000 (EA60 Hex) pipe_clk cycles-without sim_fast_train
   -- Not taking any action  when PLDIRECTEDLINKCHANGE is set


   v6pcie1 <= X"7530" when (pl_sel_lnk_rate = '1') else
              X"EA60";
   v6pcie2 <= X"00E1" when (PL_FAST_TRAIN) else
              v6pcie1;

   process (pipe_clk)
   begin
      if (pipe_clk'event and pipe_clk = '1') then

        if (pl_phy_lnkup_n = '1') then

          reg_tsx_counter <= "0000000000000000" after (TCQ)*1 ps;
          reg_filter_pipe <= '0' after (TCQ)*1 ps;

        elsif ((pl_ltssm_state = "100000") and (prev_pl_ltssm_state = "011101") and (("00" & cfg_link_status_negotiated_width) /= cap_link_width(5 downto 0)) and (pl_directed_link_change(1 downto 0) = "00")) then

          reg_tsx_counter <= "0000000000000000" after (TCQ)*1 ps;
          reg_filter_pipe <= '1' after (TCQ)*1 ps;

        elsif (filter_pipe_v6pcie0 = '1') then

          if (tsx_counter < v6pcie2) then

            reg_tsx_counter <= tsx_counter + "0000000000000001" after (TCQ)*1 ps;
            reg_filter_pipe <= '1' after (TCQ)*1 ps;

          else

            reg_tsx_counter <= "0000000000000000" after (TCQ)*1 ps;
            reg_filter_pipe <= '0' after (TCQ)*1 ps;

          end if;
        end if;
      end if;
   end process;


   filter_pipe_v6pcie0 <= '0' when (UPSTREAM_FACING) else
                          reg_filter_pipe;
   tsx_counter <= reg_tsx_counter;

   process (pipe_clk)
   begin
      if (pipe_clk'event and pipe_clk = '1') then

         if (pl_phy_lnkup_n = '1') then
            reg_prev_pl_ltssm_state <= "000000" after (TCQ)*1 ps;
         else

            reg_prev_pl_ltssm_state <= pl_ltssm_state after (TCQ)*1 ps;
         end if;
      end if;
   end process;

   prev_pl_ltssm_state <= reg_prev_pl_ltssm_state;

   cap_link_width <= to_stdlogicvector(LINK_CAP_MAX_LINK_WIDTH);

end v6_pcie;


