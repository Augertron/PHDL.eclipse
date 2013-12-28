library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.NUMERIC_STD.ALL;
library UNISIM;
use UNISIM.VComponents.all;

entity top is 
generic(
    C1_P0_MASK_SIZE         : integer := 4;
    C1_P0_DATA_PORT_SIZE    : integer := 32;
    C1_P1_MASK_SIZE         : integer := 4;
    C1_P1_DATA_PORT_SIZE    : integer := 32;
    C1_MEMCLK_PERIOD        : integer := 2500;  -- Memory data transfer clock period.
    C1_RST_ACT_LOW          : integer := 0;   -- # = 1 for active low reset,# = 0 for active high reset.
    C1_INPUT_CLK_TYPE       : string := "DIFFERENTIAL";   -- input clock type DIFFERENTIAL or SINGLE_ENDED.
    C1_CALIB_SOFT_IP        : string := "TRUE"; -- # = TRUE, Enables the soft calibration logic, # = FALSE, Disables the soft calibration logic.
    C1_SIMULATION           : string := "FALSE"; -- # = TRUE, Simulating the design. Useful to reduce the simulation time, # = FALSE, Implementing the design.
    C1_HW_TESTING           : string := "FALSE"; -- Determines the address space accessed by the traffic generator, # = FALSE, Smaller address space, # = TRUE, Large address space.
    DEBUG_EN                : integer := 0; -- # = 1, Enable debug signals/controls, = 0, Disable debug signals/controls.
    C1_MEM_ADDR_ORDER       : string := "ROW_BANK_COLUMN"; -- The order in which user address is provided to the memory controller, ROW_BANK_COLUMN or BANK_ROW_COLUMN.
    C1_NUM_DQ_PINS          : integer := 16; -- External memory data width.
    C1_MEM_ADDR_WIDTH       : integer := 14; -- External memory address width.
    C1_MEM_BANKADDR_WIDTH   : integer := 3; -- External memory bank address width.
    C3_P0_MASK_SIZE         : integer := 4;
    C3_P0_DATA_PORT_SIZE    : integer := 32;
    C3_P1_MASK_SIZE         : integer := 4;
    C3_P1_DATA_PORT_SIZE    : integer := 32;
    C3_MEMCLK_PERIOD        : integer := 2500; -- Memory data transfer clock period.
    C3_RST_ACT_LOW          : integer := 0; -- # = 1 for active low reset, # = 0 for active high reset.
    C3_INPUT_CLK_TYPE       : string := "DIFFERENTIAL"; -- input clock type DIFFERENTIAL or SINGLE_ENDED.
    C3_CALIB_SOFT_IP        : string := "TRUE"; -- # = TRUE, Enables the soft calibration logic,# = FALSE, Disables the soft calibration logic.
    C3_SIMULATION           : string := "FALSE"; -- # = TRUE, Simulating the design. Useful to reduce the simulation time, # = FALSE, Implementing the design.
    C3_HW_TESTING           : string := "FALSE"; -- Determines the address space accessed by the traffic generator, # = FALSE, Smaller address space, # = TRUE, Large address space.
    C3_MEM_ADDR_ORDER       : string := "ROW_BANK_COLUMN"; -- The order in which user address is provided to the memory controller, ROW_BANK_COLUMN or BANK_ROW_COLUMN.
    C3_NUM_DQ_PINS          : integer := 16;   -- External memory data width.
    C3_MEM_ADDR_WIDTH       : integer := 14;  -- External memory address width.
    C3_MEM_BANKADDR_WIDTH   : integer := 3); -- External memory bank address width.
port (
   calib_done                              : out std_logic;
   error                                   : out std_logic;
   mcb1_dram_dq                            : inout  std_logic_vector(C1_NUM_DQ_PINS-1 downto 0);
   mcb1_dram_a                             : out std_logic_vector(C1_MEM_ADDR_WIDTH-1 downto 0);
   mcb1_dram_ba                            : out std_logic_vector(C1_MEM_BANKADDR_WIDTH-1 downto 0);
   mcb1_dram_ras_n                         : out std_logic;
   mcb1_dram_cas_n                         : out std_logic;
   mcb1_dram_we_n                          : out std_logic;
   mcb1_dram_odt                           : out std_logic;
   mcb1_dram_reset_n                       : out std_logic;
   mcb1_dram_cke                           : out std_logic;
   mcb1_dram_dm                            : out std_logic;
   mcb1_dram_udqs                          : inout  std_logic;
   mcb1_dram_udqs_n                        : inout  std_logic;
   mcb1_rzq                                : inout  std_logic;
   mcb1_zio                                : inout  std_logic;
   mcb1_dram_udm                           : out std_logic;
   mcb1_c1_sys_clk_p                            : in  std_logic;
   mcb1_c1_sys_clk_n                            : in  std_logic;
   mcb1_c1_sys_rst_i                            : in  std_logic;
   mcb1_dram_dqs                           : inout  std_logic;
   mcb1_dram_dqs_n                         : inout  std_logic;
   mcb1_dram_ck                            : out std_logic;
   mcb1_dram_ck_n                          : out std_logic;
   
   mcb3_dram_dq                            : inout  std_logic_vector(C3_NUM_DQ_PINS-1 downto 0);
   mcb3_dram_a                             : out std_logic_vector(C3_MEM_ADDR_WIDTH-1 downto 0);
   mcb3_dram_ba                            : out std_logic_vector(C3_MEM_BANKADDR_WIDTH-1 downto 0);
   mcb3_dram_ras_n                         : out std_logic;
   mcb3_dram_cas_n                         : out std_logic;
   mcb3_dram_we_n                          : out std_logic;
   mcb3_dram_odt                           : out std_logic;
   mcb3_dram_reset_n                       : out std_logic;
   mcb3_dram_cke                           : out std_logic;
   mcb3_dram_dm                            : out std_logic;
   mcb3_dram_udqs                          : inout  std_logic;
   mcb3_dram_udqs_n                        : inout  std_logic;
   mcb3_rzq                                : inout  std_logic;
   mcb3_zio                                : inout  std_logic;
   mcb3_dram_udm                           : out std_logic;
   mcb3_c3_sys_clk_p                            : in  std_logic;
   mcb3_c3_sys_clk_n                            : in  std_logic;
   mcb3_c3_sys_rst_i                            : in  std_logic;
   mcb3_dram_dqs                           : inout  std_logic;
   mcb3_dram_dqs_n                         : inout  std_logic;
   mcb3_dram_ck                            : out std_logic;
   mcb3_dram_ck_n                          : out std_logic;

   pcie_txp : out std_logic;
   pcie_txn : out std_logic;
   pcie_rxp : in  std_logic;
   pcie_rxn : in  std_logic;
   pcie_sys_clk_p   : in  std_logic;
   pcie_sys_clk_n   : in  std_logic;
   pcie_sys_reset_n : in  std_logic;

   led  : out std_logic_vector(2 downto 0));
end top;

architecture Behavioral of top is
begin

ddr3_inst: entity work.example_top port map(
   calib_done        => calib_done,       
   error             => error,            
   mcb1_dram_dq      => mcb1_dram_dq,     
   mcb1_dram_a       => mcb1_dram_a,      
   mcb1_dram_ba      => mcb1_dram_ba,     
   mcb1_dram_ras_n   => mcb1_dram_ras_n,  
   mcb1_dram_cas_n   => mcb1_dram_cas_n,  
   mcb1_dram_we_n    => mcb1_dram_we_n,   
   mcb1_dram_odt     => mcb1_dram_odt,    
   mcb1_dram_reset_n => mcb1_dram_reset_n,
   mcb1_dram_cke     => mcb1_dram_cke,    
   mcb1_dram_dm      => mcb1_dram_dm,     
   mcb1_dram_udqs    => mcb1_dram_udqs,   
   mcb1_dram_udqs_n  => mcb1_dram_udqs_n, 
   mcb1_rzq          => mcb1_rzq,         
   mcb1_zio          => mcb1_zio,         
   mcb1_dram_udm     => mcb1_dram_udm,    
   c1_sys_clk_p      => mcb1_c1_sys_clk_p,     
   c1_sys_clk_n      => mcb1_c1_sys_clk_n,     
   c1_sys_rst_i      => mcb1_c1_sys_rst_i,     
   mcb1_dram_dqs     => mcb1_dram_dqs,    
   mcb1_dram_dqs_n   => mcb1_dram_dqs_n,  
   mcb1_dram_ck      => mcb1_dram_ck,     
   mcb1_dram_ck_n    => mcb1_dram_ck_n,   
   mcb3_dram_dq      => mcb3_dram_dq,     
   mcb3_dram_a       => mcb3_dram_a,      
   mcb3_dram_ba      => mcb3_dram_ba,     
   mcb3_dram_ras_n   => mcb3_dram_ras_n,  
   mcb3_dram_cas_n   => mcb3_dram_cas_n,  
   mcb3_dram_we_n    => mcb3_dram_we_n,   
   mcb3_dram_odt     => mcb3_dram_odt,    
   mcb3_dram_reset_n => mcb3_dram_reset_n,
   mcb3_dram_cke     => mcb3_dram_cke,    
   mcb3_dram_dm      => mcb3_dram_dm,     
   mcb3_dram_udqs    => mcb3_dram_udqs,   
   mcb3_dram_udqs_n  => mcb3_dram_udqs_n, 
   mcb3_rzq          => mcb3_rzq,         
   mcb3_zio          => mcb3_zio,         
   mcb3_dram_udm     => mcb3_dram_udm,    
   c3_sys_clk_p      => mcb3_c3_sys_clk_p,     
   c3_sys_clk_n      => mcb3_c3_sys_clk_n,     
   c3_sys_rst_i      => mcb3_c3_sys_rst_i,     
   mcb3_dram_dqs     => mcb3_dram_dqs,    
   mcb3_dram_dqs_n   => mcb3_dram_dqs_n,  
   mcb3_dram_ck      => mcb3_dram_ck,     
   mcb3_dram_ck_n    => mcb3_dram_ck_n);

pcie_inst: entity work.xilinx_pcie_1_1_ep_s6 
  generic map (FAST_TRAIN  => FALSE)
  port map (
    pci_exp_txp => pcie_txp,
    pci_exp_txn => pcie_txn,
    pci_exp_rxp => pcie_rxp,
    pci_exp_rxn => pcie_rxn,
                   
    sys_clk_p   => pcie_sys_clk_p,  
    sys_clk_n   => pcie_sys_clk_n,  
    sys_reset_n => pcie_sys_reset_n,
                   
    led_0       => led(0),      
    led_1       => led(1),      
    led_2       => led(2)); 
    
end Behavioral;

