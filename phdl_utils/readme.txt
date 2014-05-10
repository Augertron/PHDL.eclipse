This is the Eclipse project for the phdl_utils package.  It includes

phdl_utils.Actel2PHDL
phdl_utils.Xilinx2PHDL
phdl_utils.CSV2PHDL
phdl_utils.Vivado2PHDL - being added to support Xilinx Vivado output.

Create phdl_utils.jar insid Eclipse by right clicking on jarmake.xml -> Run As -> Ant Build.

Then add the resulting jarfile to the CLASSPATH variable of your OS.  Then run your commands like this.


prompt> java phdl_utils.Xilinx2PHDL inputfile.csv > outputfile.phdl

Good luck.