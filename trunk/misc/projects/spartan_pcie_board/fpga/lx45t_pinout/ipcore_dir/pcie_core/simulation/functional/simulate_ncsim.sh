#!/bin/sh

# set up the working directory
rm -rf INCA* work
mkdir work

# compile all of the files
ncvhdl -v93 -work work -update -linedebug -status -file board.f

# elaborate and run the simulation
ncelab -work work -logfile ncelab.log -access +rwc -status \
  -timescale 1ns/1ps work.board
# set BATCH_MODE=0 to run simulation in GUI mode
BATCH_MODE=1

if [ $BATCH_MODE == 1 ]; then

  # run the simulation in batch mode
  ncsim work.board

else

  # run the simulation in GUI mode
  ncsim -gui work.board -input @"simvision -input wave.sv"

fi

