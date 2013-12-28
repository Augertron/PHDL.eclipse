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
-- File       : PIO_EP_MEM.vhd
-- Description: Endpoint Memory: 8KB organized as 4 x (512 DW) BlockRAM banks.
--              Block RAM Port A: Read Port
--              Block RAM Port B: Write Port
--
-------------------------------------------------------------------------------

library ieee;
use ieee.std_logic_1164.all;

library unisim;
use unisim.vcomponents.all;

entity PIO_EP_MEM is
port (
  clk_i       : in  std_logic;

  a_rd_a_i_0  : in  std_logic_vector(8 downto 0);
  a_rd_d_o_0  : out std_logic_vector(31 downto 0);
  a_rd_en_i_0 : in  std_logic;

  b_wr_a_i_0  : in  std_logic_vector(8 downto 0);
  b_wr_d_i_0  : in  std_logic_vector(31 downto 0);
  b_wr_en_i_0 : in  std_logic;
  b_rd_d_o_0  : out std_logic_vector(31 downto 0);
  b_rd_en_i_0 : in  std_logic;

  a_rd_a_i_1  : in  std_logic_vector(8 downto 0);
  a_rd_d_o_1  : out std_logic_vector(31 downto 0);
  a_rd_en_i_1 : in  std_logic;

  b_wr_a_i_1  : in  std_logic_vector(8 downto 0);
  b_wr_d_i_1  : in  std_logic_vector(31 downto 0);
  b_wr_en_i_1 : in  std_logic;
  b_rd_d_o_1  : out std_logic_vector(31 downto 0);
  b_rd_en_i_1 : in  std_logic;

  a_rd_a_i_2  : in  std_logic_vector(8 downto 0);
  a_rd_d_o_2  : out std_logic_vector(31 downto 0);
  a_rd_en_i_2 : in  std_logic;

  b_wr_a_i_2  : in  std_logic_vector(8 downto 0);
  b_wr_d_i_2  : in  std_logic_vector(31 downto 0);
  b_wr_en_i_2 : in  std_logic;
  b_rd_d_o_2  : out std_logic_vector(31 downto 0);
  b_rd_en_i_2 : in  std_logic;

  a_rd_a_i_3  : in  std_logic_vector(8 downto 0);
  a_rd_d_o_3  : out std_logic_vector(31 downto 0);
  a_rd_en_i_3 : in  std_logic;

  b_wr_a_i_3  : in  std_logic_vector(8 downto 0);
  b_wr_d_i_3  : in  std_logic_vector(31 downto 0);
  b_wr_en_i_3 : in  std_logic;
  b_rd_d_o_3  : out std_logic_vector(31 downto 0);
  b_rd_en_i_3 : in  std_logic
);
end PIO_EP_MEM;

architecture rtl of PIO_EP_MEM is
  signal a_rd_a_0_int  : std_logic_vector(13 downto 0);
  signal b_wr_a_0_int  : std_logic_vector(13 downto 0);
  signal b_wr_en_0_int : std_logic_vector(3 downto 0);
  signal a_rd_a_1_int  : std_logic_vector(13 downto 0);
  signal b_wr_a_1_int  : std_logic_vector(13 downto 0);
  signal b_wr_en_1_int : std_logic_vector(3 downto 0);
  signal a_rd_a_2_int  : std_logic_vector(13 downto 0);
  signal b_wr_a_2_int  : std_logic_vector(13 downto 0);
  signal b_wr_en_2_int : std_logic_vector(3 downto 0);
  signal a_rd_a_3_int  : std_logic_vector(13 downto 0);
  signal b_wr_a_3_int  : std_logic_vector(13 downto 0);
  signal b_wr_en_3_int : std_logic_vector(3 downto 0);
begin

  ------------------------------------------------------------------
  --
  --  4 x 512 DWs Buffer Banks (512 x 32 bits + 512 x 4 bits)
  --
  ------------------------------------------------------------------

  a_rd_a_0_int  <= a_rd_a_i_0 & "00000";
  b_wr_a_0_int  <= b_wr_a_i_0 & "00000";
  b_wr_en_0_int <= b_wr_en_i_0 & b_wr_en_i_0 & b_wr_en_i_0 & b_wr_en_i_0;
  ep_io_mem : RAMB16BWER
  generic map (
    DOA_REG               => 1,              -- Optional output registers on A port (0 or 1)
    DOB_REG               => 1,              -- Optional output registers on B port (0 or 1)
    DATA_WIDTH_A          => 36,             -- Valid values are 1, 2, 4, 9, 18, or 36
    DATA_WIDTH_B          => 36,             -- Valid values are 1, 2, 4, 9, 18, or 36
    SIM_COLLISION_CHECK   => "ALL",          -- Collision check enable "ALL", "WARNING_ONLY",
                                             --   "GENERATE_X_ONLY" or "NONE"
    WRITE_MODE_A          => "WRITE_FIRST",  -- "WRITE_FIRST", "READ_FIRST", or "NO_CHANGE
    WRITE_MODE_B          => "WRITE_FIRST"   -- "WRITE_FIRST", "READ_FIRST", or "NO_CHANGE
  )
  port map (
    DOA    => a_rd_d_o_0,      -- 32-bit A port data output
    DOB    => b_rd_d_o_0,      -- 32-bit B port data output
    DOPA   => open,            -- 4-bit A port parity data output
    DOPB   => open,            -- 4-bit B port parity data output
    ADDRA  => a_rd_a_0_int,    -- 15-bit A port address input
    ADDRB  => b_wr_a_0_int,    -- 15-bit B port address input
    CLKA   => clk_i,           -- 1-bit A port clock input
    CLKB   => clk_i,           -- 1-bit B port clock input
    DIA    => (others => '0'), -- 32-bit A port data input
    DIB    => b_wr_d_i_0,      -- 32-bit B port data input
    DIPA   => "0000",          -- 4-bit A port parity data input
    DIPB   => "0000",          -- 4-bit B port parity data input
    ENA    => a_rd_en_i_0,     -- 1-bit A port enable input
    ENB    => b_rd_en_i_0,     -- 1-bit B port enable input
    REGCEA => '1',             -- 1-bit A port register enable input
    REGCEB => '1',             -- 1-bit B port register enable input
    RSTA   => '0',             -- 1-bit A port set/reset input
    RSTB   => '0',             -- 1-bit B port set/reset input
    WEA    => "0000",          -- 4-bit A port write enable input
    WEB    => b_wr_en_0_int    -- 4-bit B port write enable input
  );

  a_rd_a_1_int  <= a_rd_a_i_1 & "00000";
  b_wr_a_1_int  <= b_wr_a_i_1 & "00000";
  b_wr_en_1_int <= b_wr_en_i_1 & b_wr_en_i_1 & b_wr_en_i_1 & b_wr_en_i_1;
  ep_mem32 : RAMB16BWER
  generic map (
    DOA_REG               => 1,              -- Optional output registers on A port (0 or 1)
    DOB_REG               => 1,              -- Optional output registers on B port (0 or 1)
    DATA_WIDTH_A          => 36,             -- Valid values are 1, 2, 4, 9, 18, or 36
    DATA_WIDTH_B          => 36,             -- Valid values are 1, 2, 4, 9, 18, or 36
    SIM_COLLISION_CHECK   => "ALL",          -- Collision check enable "ALL", "WARNING_ONLY",
                                             --   "GENERATE_X_ONLY" or "NONE"
    WRITE_MODE_A          => "WRITE_FIRST",  -- "WRITE_FIRST", "READ_FIRST", or "NO_CHANGE
    WRITE_MODE_B          => "WRITE_FIRST"   -- "WRITE_FIRST", "READ_FIRST", or "NO_CHANGE
  )
  port map (
    DOA    => a_rd_d_o_1,      -- 32-bit A port data output
    DOB    => b_rd_d_o_1,      -- 32-bit B port data output
    DOPA   => open,            -- 4-bit A port parity data output
    DOPB   => open,            -- 4-bit B port parity data output
    ADDRA  => a_rd_a_1_int,    -- 15-bit A port address input
    ADDRB  => b_wr_a_1_int,    -- 15-bit B port address input
    CLKA   => clk_i,           -- 1-bit A port clock input
    CLKB   => clk_i,           -- 1-bit B port clock input
    DIA    => (others => '0'), -- 32-bit A port data input
    DIB    => b_wr_d_i_1,      -- 32-bit B port data input
    DIPA   => "0000",          -- 4-bit A port parity data input
    DIPB   => "0000",          -- 4-bit B port parity data input
    ENA    => a_rd_en_i_1,     -- 1-bit A port enable input
    ENB    => b_rd_en_i_1,     -- 1-bit B port enable input
    REGCEA => '1',             -- 1-bit A port register enable input
    REGCEB => '1',             -- 1-bit B port register enable input
    RSTA   => '0',             -- 1-bit A port set/reset input
    RSTB   => '0',             -- 1-bit B port set/reset input
    WEA    => "0000",          -- 4-bit A port write enable input
    WEB    => b_wr_en_1_int    -- 4-bit B port write enable input
  );

  a_rd_a_2_int  <= a_rd_a_i_2 & "00000";
  b_wr_a_2_int  <= b_wr_a_i_2 & "00000";
  b_wr_en_2_int <= b_wr_en_i_2 & b_wr_en_i_2 & b_wr_en_i_2 & b_wr_en_i_2;
  ep_mem64 : RAMB16BWER
  generic map (
    DOA_REG               => 1,              -- Optional output registers on A port (0 or 1)
    DOB_REG               => 1,              -- Optional output registers on B port (0 or 1)
    DATA_WIDTH_A          => 36,             -- Valid values are 1, 2, 4, 9, 18, or 36
    DATA_WIDTH_B          => 36,             -- Valid values are 1, 2, 4, 9, 18, or 36
    SIM_COLLISION_CHECK   => "ALL",          -- Collision check enable "ALL", "WARNING_ONLY",
                                             --   "GENERATE_X_ONLY" or "NONE"
    WRITE_MODE_A          => "WRITE_FIRST",  -- "WRITE_FIRST", "READ_FIRST", or "NO_CHANGE
    WRITE_MODE_B          => "WRITE_FIRST"   -- "WRITE_FIRST", "READ_FIRST", or "NO_CHANGE
  )
  port map (
    DOA    => a_rd_d_o_2,      -- 32-bit A port data output
    DOB    => b_rd_d_o_2,      -- 32-bit B port data output
    DOPA   => open,            -- 4-bit A port parity data output
    DOPB   => open,            -- 4-bit B port parity data output
    ADDRA  => a_rd_a_2_int,    -- 15-bit A port address input
    ADDRB  => b_wr_a_2_int,    -- 15-bit B port address input
    CLKA   => clk_i,           -- 1-bit A port clock input
    CLKB   => clk_i,           -- 1-bit B port clock input
    DIA    => (others => '0'), -- 32-bit A port data input
    DIB    => b_wr_d_i_2,      -- 32-bit B port data input
    DIPA   => "0000",          -- 4-bit A port parity data input
    DIPB   => "0000",          -- 4-bit B port parity data input
    ENA    => a_rd_en_i_2,     -- 1-bit A port enable input
    ENB    => b_rd_en_i_2,     -- 1-bit B port enable input
    REGCEA => '1',             -- 1-bit A port register enable input
    REGCEB => '1',             -- 1-bit B port register enable input
    RSTA   => '0',             -- 1-bit A port set/reset input
    RSTB   => '0',             -- 1-bit B port set/reset input
    WEA    => "0000",          -- 4-bit A port write enable input
    WEB    => b_wr_en_2_int    -- 4-bit B port write enable input
  );

  a_rd_a_3_int  <= a_rd_a_i_3 & "00000";
  b_wr_a_3_int  <= b_wr_a_i_3 & "00000";
  b_wr_en_3_int <= b_wr_en_i_3 & b_wr_en_i_3 & b_wr_en_i_3 & b_wr_en_i_3;
  ep_mem_erom : RAMB16BWER
  generic map (
    DOA_REG               => 1,              -- Optional output registers on A port (0 or 1)
    DOB_REG               => 1,              -- Optional output registers on B port (0 or 1)
    DATA_WIDTH_A          => 36,             -- Valid values are 1, 2, 4, 9, 18, or 36
    DATA_WIDTH_B          => 36,             -- Valid values are 1, 2, 4, 9, 18, or 36
    SIM_COLLISION_CHECK   => "ALL",          -- Collision check enable "ALL", "WARNING_ONLY",
                                             --   "GENERATE_X_ONLY" or "NONE"
    WRITE_MODE_A          => "WRITE_FIRST",  -- "WRITE_FIRST", "READ_FIRST", or "NO_CHANGE
    WRITE_MODE_B          => "WRITE_FIRST"   -- "WRITE_FIRST", "READ_FIRST", or "NO_CHANGE
  )
  port map (
    DOA    => a_rd_d_o_3,      -- 32-bit A port data output
    DOB    => b_rd_d_o_3,      -- 32-bit B port data output
    DOPA   => open,            -- 4-bit A port parity data output
    DOPB   => open,            -- 4-bit B port parity data output
    ADDRA  => a_rd_a_3_int,    -- 15-bit A port address input
    ADDRB  => b_wr_a_3_int,    -- 15-bit B port address input
    CLKA   => clk_i,           -- 1-bit A port clock input
    CLKB   => clk_i,           -- 1-bit B port clock input
    DIA    => (others => '0'), -- 32-bit A port data input
    DIB    => b_wr_d_i_3,      -- 32-bit B port data input
    DIPA   => "0000",          -- 4-bit A port parity data input
    DIPB   => "0000",          -- 4-bit B port parity data input
    ENA    => a_rd_en_i_3,     -- 1-bit A port enable input
    ENB    => b_rd_en_i_3,     -- 1-bit B port enable input
    REGCEA => '1',             -- 1-bit A port register enable input
    REGCEB => '1',             -- 1-bit B port register enable input
    RSTA   => '0',             -- 1-bit A port set/reset input
    RSTB   => '0',             -- 1-bit B port set/reset input
    WEA    => "0000",          -- 4-bit A port write enable input
    WEB    => b_wr_en_3_int    -- 4-bit B port write enable input
  );

end; -- PIO_EP_MEM

