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
-- File       : pcie_core.vho
-------------------------------------------------------------------------------
-- The following must be inserted into your VHDL file for this
-- core to be instantiated. Change the instance name and port connections
-- (in parentheses) to your own signal names.

------------- Begin Cut here for COMPONENT Declaration ------ COMP_TAG
  component pcie_core is
  generic (
    TL_TX_RAM_RADDR_LATENCY           : integer    := 0;
    TL_TX_RAM_RDATA_LATENCY           : integer    := 2;
    TL_RX_RAM_RADDR_LATENCY           : integer    := 0;
    TL_RX_RAM_RDATA_LATENCY           : integer    := 2;
    TL_RX_RAM_WRITE_LATENCY           : integer    := 0;
    VC0_TX_LASTPACKET                 : integer    := 14;
    VC0_RX_RAM_LIMIT                  : bit_vector := x"7FF";
    VC0_TOTAL_CREDITS_PH              : integer    := 32;
    VC0_TOTAL_CREDITS_PD              : integer    := 211;
    VC0_TOTAL_CREDITS_NPH             : integer    := 8;
    VC0_TOTAL_CREDITS_CH              : integer    := 40;
    VC0_TOTAL_CREDITS_CD              : integer    := 211;
    VC0_CPL_INFINITE                  : boolean    := TRUE;
    BAR0                              : bit_vector := x"FFFFFC00";
    BAR1                              : bit_vector := x"FFFFC000";
    BAR2                              : bit_vector := x"FF000000";
    BAR3                              : bit_vector := x"00000000";
    BAR4                              : bit_vector := x"00000000";
    BAR5                              : bit_vector := x"00000000";
    EXPANSION_ROM                     : bit_vector := "0000000000000000000000";
    DISABLE_BAR_FILTERING             : boolean    := FALSE;
    DISABLE_ID_CHECK                  : boolean    := FALSE;
    TL_TFC_DISABLE                    : boolean    := FALSE;
    TL_TX_CHECKS_DISABLE              : boolean    := FALSE;
    USR_CFG                           : boolean    := FALSE;
    USR_EXT_CFG                       : boolean    := FALSE;
    DEV_CAP_MAX_PAYLOAD_SUPPORTED     : integer    := 2;
    CLASS_CODE                        : bit_vector := x"050000";
    CARDBUS_CIS_POINTER               : bit_vector := x"00000000";
    PCIE_CAP_CAPABILITY_VERSION       : bit_vector := x"1";
    PCIE_CAP_DEVICE_PORT_TYPE         : bit_vector := x"0";
    PCIE_CAP_SLOT_IMPLEMENTED         : boolean    := FALSE;
    PCIE_CAP_INT_MSG_NUM              : bit_vector := "00000";
    DEV_CAP_PHANTOM_FUNCTIONS_SUPPORT : integer    := 0;
    DEV_CAP_EXT_TAG_SUPPORTED         : boolean    := FALSE;
    DEV_CAP_ENDPOINT_L0S_LATENCY      : integer    := 7;
    DEV_CAP_ENDPOINT_L1_LATENCY       : integer    := 7;
    SLOT_CAP_ATT_BUTTON_PRESENT       : boolean    := FALSE;
    SLOT_CAP_ATT_INDICATOR_PRESENT    : boolean    := FALSE;
    SLOT_CAP_POWER_INDICATOR_PRESENT  : boolean    := FALSE;
    DEV_CAP_ROLE_BASED_ERROR          : boolean    := TRUE;
    LINK_CAP_ASPM_SUPPORT             : integer    := 1;
    LINK_CAP_L0S_EXIT_LATENCY         : integer    := 7;
    LINK_CAP_L1_EXIT_LATENCY          : integer    := 7;
    LL_ACK_TIMEOUT                    : bit_vector := x"0204";
    LL_ACK_TIMEOUT_EN                 : boolean    := FALSE;
    LL_REPLAY_TIMEOUT                 : bit_vector := x"0204";
    LL_REPLAY_TIMEOUT_EN              : boolean    := FALSE;
    MSI_CAP_MULTIMSGCAP               : integer    := 0;
    MSI_CAP_MULTIMSG_EXTENSION        : integer    := 0;
    LINK_STATUS_SLOT_CLOCK_CONFIG     : boolean    := FALSE;
    PLM_AUTO_CONFIG                   : boolean    := FALSE;
    FAST_TRAIN                        : boolean    := FALSE;
    ENABLE_RX_TD_ECRC_TRIM            : boolean    := FALSE;
    DISABLE_SCRAMBLING                : boolean    := FALSE;
    PM_CAP_VERSION                    : integer    := 3;
    PM_CAP_PME_CLOCK                  : boolean    := FALSE;
    PM_CAP_DSI                        : boolean    := FALSE;
    PM_CAP_AUXCURRENT                 : integer    := 0;
    PM_CAP_D1SUPPORT                  : boolean    := TRUE;
    PM_CAP_D2SUPPORT                  : boolean    := TRUE;
    PM_CAP_PMESUPPORT                 : bit_vector := x"0F";
    PM_DATA0                          : bit_vector := x"00";
    PM_DATA_SCALE0                    : bit_vector := x"0";
    PM_DATA1                          : bit_vector := x"00";
    PM_DATA_SCALE1                    : bit_vector := x"0";
    PM_DATA2                          : bit_vector := x"00";
    PM_DATA_SCALE2                    : bit_vector := x"0";
    PM_DATA3                          : bit_vector := x"00";
    PM_DATA_SCALE3                    : bit_vector := x"0";
    PM_DATA4                          : bit_vector := x"00";
    PM_DATA_SCALE4                    : bit_vector := x"0";
    PM_DATA5                          : bit_vector := x"00";
    PM_DATA_SCALE5                    : bit_vector := x"0";
    PM_DATA6                          : bit_vector := x"00";
    PM_DATA_SCALE6                    : bit_vector := x"0";
    PM_DATA7                          : bit_vector := x"00";
    PM_DATA_SCALE7                    : bit_vector := x"0";
    PCIE_GENERIC                      : bit_vector := "000011101111";
    GTP_SEL                           : integer    := 0;
    CFG_VEN_ID                        : std_logic_vector(15 downto 0) := x"10EE";
    CFG_DEV_ID                        : std_logic_vector(15 downto 0) := x"0007";
    CFG_REV_ID                        : std_logic_vector(7 downto 0)  := x"00";
    CFG_SUBSYS_VEN_ID                 : std_logic_vector(15 downto 0) := x"10EE";
    CFG_SUBSYS_ID                     : std_logic_vector(15 downto 0) := x"0007";
    REF_CLK_FREQ                      : integer    := 1
  );
  port (
    -- PCI Express Fabric Interface
    pci_exp_txp             : out std_logic;
    pci_exp_txn             : out std_logic;
    pci_exp_rxp             : in  std_logic;
    pci_exp_rxn             : in  std_logic;

    -- Transaction (TRN) Interface
    trn_lnk_up_n            : out std_logic;

    -- Tx
    trn_td                  : in  std_logic_vector(31 downto 0);
    trn_tsof_n              : in  std_logic;
    trn_teof_n              : in  std_logic;
    trn_tsrc_rdy_n          : in  std_logic;
    trn_tdst_rdy_n          : out std_logic;
    trn_terr_drop_n         : out std_logic;
    trn_tsrc_dsc_n          : in  std_logic;
    trn_terrfwd_n           : in  std_logic;
    trn_tbuf_av             : out std_logic_vector(5 downto 0);
    trn_tstr_n              : in  std_logic;
    trn_tcfg_req_n          : out std_logic;
    trn_tcfg_gnt_n          : in  std_logic;

    -- Rx
    trn_rd                  : out std_logic_vector(31 downto 0);
    trn_rsof_n              : out std_logic;
    trn_reof_n              : out std_logic;
    trn_rsrc_rdy_n          : out std_logic;
    trn_rsrc_dsc_n          : out std_logic;
    trn_rdst_rdy_n          : in  std_logic;
    trn_rerrfwd_n           : out std_logic;
    trn_rnp_ok_n            : in  std_logic;
    trn_rbar_hit_n          : out std_logic_vector(6 downto 0);
    trn_fc_sel              : in  std_logic_vector(2 downto 0);
    trn_fc_nph              : out std_logic_vector(7 downto 0);
    trn_fc_npd              : out std_logic_vector(11 downto 0);
    trn_fc_ph               : out std_logic_vector(7 downto 0);
    trn_fc_pd               : out std_logic_vector(11 downto 0);
    trn_fc_cplh             : out std_logic_vector(7 downto 0);
    trn_fc_cpld             : out std_logic_vector(11 downto 0);

    -- Host (CFG) Interface
    cfg_do                  : out std_logic_vector(31 downto 0);
    cfg_rd_wr_done_n        : out std_logic;
    cfg_dwaddr              : in  std_logic_vector(9 downto 0);
    cfg_rd_en_n             : in  std_logic;
    cfg_err_ur_n            : in  std_logic;
    cfg_err_cor_n           : in  std_logic;
    cfg_err_ecrc_n          : in  std_logic;
    cfg_err_cpl_timeout_n   : in  std_logic;
    cfg_err_cpl_abort_n     : in  std_logic;
    cfg_err_posted_n        : in  std_logic;
    cfg_err_locked_n        : in  std_logic;
    cfg_err_tlp_cpl_header  : in  std_logic_vector(47 downto 0);
    cfg_err_cpl_rdy_n       : out std_logic;
    cfg_interrupt_n         : in  std_logic;
    cfg_interrupt_rdy_n     : out std_logic;
    cfg_interrupt_assert_n  : in  std_logic;
    cfg_interrupt_do        : out std_logic_vector(7 downto 0);
    cfg_interrupt_di        : in  std_logic_vector(7 downto 0);
    cfg_interrupt_mmenable  : out std_logic_vector(2 downto 0);
    cfg_interrupt_msienable : out std_logic;
    cfg_turnoff_ok_n        : in  std_logic;
    cfg_to_turnoff_n        : out std_logic;
    cfg_pm_wake_n           : in  std_logic;
    cfg_pcie_link_state_n   : out std_logic_vector(2 downto 0);
    cfg_trn_pending_n       : in  std_logic;
    cfg_dsn                 : in  std_logic_vector(63 downto 0);
    cfg_bus_number          : out std_logic_vector(7 downto 0);
    cfg_device_number       : out std_logic_vector(4 downto 0);
    cfg_function_number     : out std_logic_vector(2 downto 0);
    cfg_status              : out std_logic_vector(15 downto 0);
    cfg_command             : out std_logic_vector(15 downto 0);
    cfg_dstatus             : out std_logic_vector(15 downto 0);
    cfg_dcommand            : out std_logic_vector(15 downto 0);
    cfg_lstatus             : out std_logic_vector(15 downto 0);
    cfg_lcommand            : out std_logic_vector(15 downto 0);

    -- System Interface
    sys_clk                 : in  std_logic;
    sys_reset_n             : in  std_logic;
    trn_clk                 : out std_logic;
    trn_reset_n             : out std_logic;
    received_hot_reset      : out std_logic
    );
  end component pcie_core;
-- COMP_TAG_END ------ End COMPONENT Declaration ------------

-- The following code must appear in the VHDL architecture
-- body. Substitute your own instance name and net names.
----------- Begin Cut here for INSTANTIATION Template --- INST_TAG
  YourInstanceName : pcie_core
  port map (
    pci_exp_txp             => pci_exp_txp,
    pci_exp_txn             => pci_exp_txn,
    pci_exp_rxp             => pci_exp_rxp,
    pci_exp_rxn             => pci_exp_rxn,
    trn_lnk_up_n            => trn_lnk_up_n,
    trn_td                  => trn_td,                   -- Bus [31 : 0]
    trn_tsof_n              => trn_tsof_n,
    trn_teof_n              => trn_teof_n,
    trn_tsrc_rdy_n          => trn_tsrc_rdy_n,
    trn_tdst_rdy_n          => trn_tdst_rdy_n,
    trn_terr_drop_n         => trn_terr_drop_n,
    trn_tsrc_dsc_n          => trn_tsrc_dsc_n,
    trn_terrfwd_n           => trn_terrfwd_n,
    trn_tbuf_av             => trn_tbuf_av,              -- Bus [31 : 0]
    trn_tstr_n              => trn_tstr_n,
    trn_tcfg_req_n          => trn_tcfg_req_n,
    trn_tcfg_gnt_n          => trn_tcfg_gnt_n,
    trn_rd                  => trn_rd,                   -- Bus [31 : 0]
    trn_rsof_n              => trn_rsof_n,
    trn_reof_n              => trn_reof_n,
    trn_rsrc_rdy_n          => trn_rsrc_rdy_n,
    trn_rsrc_dsc_n          => trn_rsrc_dsc_n,
    trn_rdst_rdy_n          => trn_rdst_rdy_n,
    trn_rerrfwd_n           => trn_rerrfwd_n,
    trn_rnp_ok_n            => trn_rnp_ok_n,
    trn_rbar_hit_n          => trn_rbar_hit_n,           -- Bus [31 : 0]
    trn_fc_sel              => trn_fc_sel,               -- Bus [31 : 0]
    trn_fc_nph              => trn_fc_nph,               -- Bus [31 : 0]
    trn_fc_npd              => trn_fc_npd,               -- Bus [31 : 0]
    trn_fc_ph               => trn_fc_ph,                -- Bus [31 : 0]
    trn_fc_pd               => trn_fc_pd,                -- Bus [31 : 0]
    trn_fc_cplh             => trn_fc_cplh,              -- Bus [31 : 0]
    trn_fc_cpld             => trn_fc_cpld,              -- Bus [31 : 0]
    cfg_do                  => cfg_do,                   -- Bus [31 : 0]
    cfg_rd_wr_done_n        => cfg_rd_wr_done_n,
    cfg_dwaddr              => cfg_dwaddr,               -- Bus [31 : 0]
    cfg_rd_en_n             => cfg_rd_en_n,
    cfg_err_ur_n            => cfg_err_ur_n,
    cfg_err_cor_n           => cfg_err_cor_n,
    cfg_err_ecrc_n          => cfg_err_ecrc_n,
    cfg_err_cpl_timeout_n   => cfg_err_cpl_timeout_n,
    cfg_err_cpl_abort_n     => cfg_err_cpl_abort_n,
    cfg_err_posted_n        => cfg_err_posted_n,
    cfg_err_locked_n        => cfg_err_locked_n,
    cfg_err_tlp_cpl_header  => cfg_err_tlp_cpl_header,   -- Bus [31 : 0]
    cfg_err_cpl_rdy_n       => cfg_err_cpl_rdy_n,
    cfg_interrupt_n         => cfg_interrupt_n,
    cfg_interrupt_rdy_n     => cfg_interrupt_rdy_n,
    cfg_interrupt_assert_n  => cfg_interrupt_assert_n,
    cfg_interrupt_do        => cfg_interrupt_do,         -- Bus [31 : 0]
    cfg_interrupt_di        => cfg_interrupt_di,         -- Bus [31 : 0]
    cfg_interrupt_mmenable  => cfg_interrupt_mmenable,   -- Bus [31 : 0]
    cfg_interrupt_msienable => cfg_interrupt_msienable,
    cfg_turnoff_ok_n        => cfg_turnoff_ok_n,
    cfg_to_turnoff_n        => cfg_to_turnoff_n,
    cfg_pm_wake_n           => cfg_pm_wake_n,
    cfg_pcie_link_state_n   => cfg_pcie_link_state_n,    -- Bus [31 : 0]
    cfg_trn_pending_n       => cfg_trn_pending_n,
    cfg_dsn                 => cfg_dsn,                  -- Bus [31 : 0]
    cfg_bus_number          => cfg_bus_number,           -- Bus [31 : 0]
    cfg_device_number       => cfg_device_number,        -- Bus [31 : 0]
    cfg_function_number     => cfg_function_number,      -- Bus [31 : 0]
    cfg_status              => cfg_status,               -- Bus [31 : 0]
    cfg_command             => cfg_command,              -- Bus [31 : 0]
    cfg_dstatus             => cfg_dstatus,              -- Bus [31 : 0]
    cfg_dcommand            => cfg_dcommand,             -- Bus [31 : 0]
    cfg_lstatus             => cfg_lstatus,              -- Bus [31 : 0]
    cfg_lcommand            => cfg_lcommand,             -- Bus [31 : 0]
    sys_clk                 => sys_clk,
    sys_reset_n             => sys_reset_n,
    trn_clk                 => trn_clk,
    trn_reset_n             => trn_reset_n,
    received_hot_reset      => received_hot_reset
  );

// INST_TAG_END ------ End INSTANTIATION Template ---------

