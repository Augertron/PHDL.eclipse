library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.NUMERIC_STD.ALL;
library UNISIM;
use UNISIM.VComponents.all;

entity top is Port ( 
           db1_p : out  STD_LOGIC_VECTOR (13 downto 0);
           db1_n : out  STD_LOGIC_VECTOR (13 downto 0);
           db0_p : out  STD_LOGIC_VECTOR (13 downto 0);
           db0_n : out  STD_LOGIC_VECTOR (13 downto 0);
           sync_out_p : out  STD_LOGIC;
           sync_out_n : out  STD_LOGIC;
           sync_in_p : in  STD_LOGIC;
           sync_in_n : in  STD_LOGIC;
           dco_p : out  STD_LOGIC;
           dco_n : out  STD_LOGIC;
           dci_p : in  STD_LOGIC;
           dci_n : in  STD_LOGIC;
           spi_sdi : in  STD_LOGIC;
           spi_sdo : out  STD_LOGIC;
           spi_cs : out  STD_LOGIC;
           spi_sclk : out  STD_LOGIC;
           reset : out  STD_LOGIC);
end top;

architecture Behavioral of top is
   signal dci, dco, sync_in, sync_out, spi_sdi_reg : std_logic;
   signal sync_vec : std_logic_vector( 1 downto 0);
   signal db0, db1 : std_logic_vector(13 downto 0);
   signal count : std_logic_vector(63 downto 0);
begin

   IBUFGDS_dci: IBUFGDS port map(O=>dci,     I=>dci_p,     IB=>dci_n);
   IBUFDS_sync_in : IBUFDS  port map(O=>sync_in, I=>sync_in_p, IB=>sync_in_n);
   IDDR_sync_in : IDDR generic map(DDR_CLK_EDGE=>"SAME_EDGE") port map(Q1=>sync_vec(0), Q2=>sync_vec(1), C=>dci, CE=>'1', D=>sync_in, R=>'0', S=>'0');
   ODDR_sync_out : ODDR generic map(DDR_CLK_EDGE=>"SAME_EDGE") port map(Q=>sync_out, C=>dci, CE=>'1', D1=>sync_vec(0), D2=>sync_vec(1), R=>'0', S=>'0');
   OBUFDS_sync_out : OBUFDS port map(O=>sync_out_p, OB=>sync_out_n, I=>sync_out);
   ODDR_dco : ODDR generic map(DDR_CLK_EDGE=>"SAME_EDGE") port map(Q=>dco, C=>dci, CE=>'1', D1=>'0', D2=>'1', R=>'0', S=>'0');
   OBUFDS_dco : OBUFDS port map(O=>dco_p, OB=>dco_n, I=>dco);
   
   dbx_gen: for i in db0_p'range generate begin
         ODDR_db0 : ODDR generic map(DDR_CLK_EDGE=>"SAME_EDGE") port map(Q=>db0(i), C=>dci, CE=>'1', D1=>count(i+0),  D2=>count(i+14), R=>'0', S=>'0');  
         ODDR_db1 : ODDR generic map(DDR_CLK_EDGE=>"SAME_EDGE") port map(Q=>db1(i), C=>dci, CE=>'1', D1=>count(i+28), D2=>count(i+42), R=>'0', S=>'0');
         OBUFDS_db0 : OBUFDS port map(O=>db0_p(i), OB=>db0_n(i), I=>db0(i));      
         OBUFDS_db1 : OBUFDS port map(O=>db1_p(i), OB=>db1_n(i), I=>db1(i));            
   end generate;
   
   count_proc:process
   begin
      wait until rising_edge(dci);
      count <= std_logic_vector(unsigned(count)+1);
   end process;
   
   spi_regs_proc:process
   begin
      wait until rising_edge(dci);
      spi_sdi_reg <= spi_sdi;
      spi_sdo     <= spi_sdi_reg;
      spi_cs      <= count(56);
      reset       <= count(57);
      spi_sclk    <= count(58);
   end process;
           
end Behavioral;

