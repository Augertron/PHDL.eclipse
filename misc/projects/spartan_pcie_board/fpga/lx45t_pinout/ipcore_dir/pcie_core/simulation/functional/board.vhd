-------------------------------------------------------------------------------
--
-- (c) Copyright 2001, 2002, 2003, 2004, 2005, 2007, 2008, 2009 Xilinx, Inc. All rights reserved.
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
-- File       : board.vhd
-- Description: Top level testbench
--
-------------------------------------------------------------------------------

library ieee;
use ieee.std_logic_1164.all;

entity board is
  generic
  (
    REF_CLK_FREQ                 : integer := 1    -- 0 - 100 MHz, 1 - 125 MHz
  );
end board;

architecture rtl of board is

  --
  -- Functions
  --
  function REF_CLK_HALF_CYCLE(FREQ_SEL : integer) return integer is
  begin
    case FREQ_SEL is
      when 0 => return 5000; -- 100 MHz / 5000 ps half-cycle
      when 1 => return 4000; -- 125 MHz / 4000 ps half-cycle
      when others => return 1; -- invalid case
    end case;
  end REF_CLK_HALF_CYCLE;

  --
  -- Components
  --
  component xilinx_pcie_1_1_ep_s6 is
    generic
    (
      FAST_TRAIN                        : boolean    := FALSE
    );
    port
    (
      pci_exp_txp : out std_logic;
      pci_exp_txn : out std_logic;
      pci_exp_rxp : in  std_logic;
      pci_exp_rxn : in  std_logic;

      sys_clk_p   : in  std_logic;
      sys_clk_n   : in  std_logic;
      sys_reset_n : in  std_logic;

      led_0       : out std_logic;
      led_1       : out std_logic;
      led_2       : out std_logic
    );
  end component xilinx_pcie_1_1_ep_s6;

  component xilinx_pcie_2_0_rport_v6 is
    generic
    (
      REF_CLK_FREQ                      : integer := 0;
      ALLOW_X8_GEN2                     : boolean := FALSE;
      PL_FAST_TRAIN                     : boolean := FALSE;
      LINK_CAP_MAX_LINK_SPEED           : bit_vector := X"1";
      DEVICE_ID                         : bit_vector := X"0007";
      LINK_CAP_MAX_LINK_WIDTH           : bit_vector := X"08";
      LTSSM_MAX_LINK_WIDTH              : bit_vector := X"08";
      LINK_CAP_MAX_LINK_WIDTH_int       : integer := 8;
      LINK_CTRL2_TARGET_LINK_SPEED      : bit_vector := X"2";
      DEV_CAP_MAX_PAYLOAD_SUPPORTED     : integer := 2;
      USER_CLK_FREQ                     : integer := 3;
      VC0_TX_LASTPACKET                 : integer := 31;
      VC0_RX_RAM_LIMIT                  : bit_vector := X"03FF";
      VC0_TOTAL_CREDITS_CD              : integer := 154;
      VC0_TOTAL_CREDITS_PD              : integer := 154
    );
    port (
      sys_clk        : in  std_logic;
      sys_reset_n    : in  std_logic;

      pci_exp_rxn    : in  std_logic_vector((LINK_CAP_MAX_LINK_WIDTH_int - 1) downto 0);
      pci_exp_rxp    : in  std_logic_vector((LINK_CAP_MAX_LINK_WIDTH_int - 1) downto 0);
      pci_exp_txn    : out std_logic_vector((LINK_CAP_MAX_LINK_WIDTH_int - 1) downto 0);
      pci_exp_txp    : out std_logic_vector((LINK_CAP_MAX_LINK_WIDTH_int - 1) downto 0)
    );
  end component xilinx_pcie_2_0_rport_v6;

  component sys_clk_gen is
    generic
    (
      HALFCYCLE : integer := 500;
      OFFSET    : integer := 0
    );
    port
    (
      sys_clk   : out std_logic
    );
  end component sys_clk_gen;

  component sys_clk_gen_ds is
    generic
    (
      HALFCYCLE : integer := 500;
      OFFSET    : integer := 0
    );
    port
    (
      sys_clk_p : out std_logic;
      sys_clk_n : out std_logic
    );
  end component sys_clk_gen_ds;

  --
  -- System reset
  --
  signal  sys_reset_n    : std_logic;

  --
  -- System clocks
  --
  signal  rp_sys_clk     : std_logic;
  signal  ep_sys_clk_p   : std_logic;
  signal  ep_sys_clk_n   : std_logic;

  --
  -- PCI-Express Serial Interconnect
  --
  signal  ep_pci_exp_txn : std_logic_vector(0 downto 0);
  signal  ep_pci_exp_txp : std_logic_vector(0 downto 0);
  signal  rp_pci_exp_txn : std_logic_vector(0 downto 0);
  signal  rp_pci_exp_txp : std_logic_vector(0 downto 0);

  --
  -- Misc. signals
  --
  signal  led_0          : std_logic;
  signal  led_1          : std_logic;
  signal  led_2          : std_logic;

begin

  --
  -- PCI-Express Endpoint Instance
  --
  EP : xilinx_pcie_1_1_ep_s6
  generic map (
    FAST_TRAIN               => TRUE
  )
  port map (
    -- SYS Inteface
    sys_clk_p                => ep_sys_clk_p,
    sys_clk_n                => ep_sys_clk_n,
    sys_reset_n              => sys_reset_n,

    -- PCI-Express Interface
    pci_exp_txn              => ep_pci_exp_txn(0),
    pci_exp_txp              => ep_pci_exp_txp(0),
    pci_exp_rxn              => rp_pci_exp_txn(0),
    pci_exp_rxp              => rp_pci_exp_txp(0),

    -- Misc signals
    led_0                    => led_0,
    led_1                    => led_1,
    led_2                    => led_2
  );

  --
  -- PCI-Express Model Root Port Instance
  --
  RP : xilinx_pcie_2_0_rport_v6
  generic map (
    REF_CLK_FREQ                  => REF_CLK_FREQ,
    PL_FAST_TRAIN                 => TRUE,
    ALLOW_X8_GEN2                 => FALSE,
    LINK_CAP_MAX_LINK_SPEED       => X"1",
    DEVICE_ID                     => X"0007",
    LINK_CAP_MAX_LINK_WIDTH       => X"01",
    LTSSM_MAX_LINK_WIDTH          => X"01",
    LINK_CAP_MAX_LINK_WIDTH_int   => 1,
    LINK_CTRL2_TARGET_LINK_SPEED  => X"1",
    DEV_CAP_MAX_PAYLOAD_SUPPORTED => 2,
    USER_CLK_FREQ                 => 3,
    VC0_TX_LASTPACKET             => 31,
    VC0_RX_RAM_LIMIT              => X"03FF",
    VC0_TOTAL_CREDITS_CD          => 154,
    VC0_TOTAL_CREDITS_PD          => 154
  )
  port map (
    -- SYS Inteface
    sys_clk                  => rp_sys_clk,
    sys_reset_n              => sys_reset_n,

    -- PCI-Express Interface
    pci_exp_txn              => rp_pci_exp_txn,
    pci_exp_txp              => rp_pci_exp_txp,
    pci_exp_rxn              => ep_pci_exp_txn,
    pci_exp_rxp              => ep_pci_exp_txp
  );

  --
  -- Generate system clocks and reset
  --
  CLK_GEN_RP : sys_clk_gen
  generic map (
    HALFCYCLE => REF_CLK_HALF_CYCLE(REF_CLK_FREQ),
    OFFSET    => 0
  )
  port map (
    sys_clk => rp_sys_clk
  );

  CLK_GEN_EP : sys_clk_gen_ds
  generic map (
    HALFCYCLE => REF_CLK_HALF_CYCLE(REF_CLK_FREQ),
    OFFSET    => 0
  )
  port map (
    sys_clk_p => ep_sys_clk_p,
    sys_clk_n => ep_sys_clk_n
  );


  BOARD_INIT : process
  begin
    report("[" & time'image(now) & "] : System Reset Asserted...");
    sys_reset_n <= '0';

    for n in 0 to 499 loop
      wait until rising_edge(ep_sys_clk_p);
    end loop;

    report("[" & time'image(now) & "] : System Reset De-asserted...");
    sys_reset_n <= '1';

    wait until falling_edge(sys_reset_n); -- forever
  end process BOARD_INIT;

end; -- board
