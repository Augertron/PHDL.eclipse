if exists("b:current_syntax")
  finish
endif

syntax clear
syntax sync fromstart

syntax keyword Keyword attr combine design device import info inpin inst iopin ncpin net newattr ocpin oepin of open outpin package passpin pin port pwrpin subdesign subinst suppin this tripin
syntax match   Comment "//.*$"
syntax region  Comment start=/\/\*/ end=/\*\//
syntax region  String  start=/"/ skip=/\\"/ end=/"/
syntax match   Number  "\<[0-9]\+\(\.[0-9]\+\)\?\>"
syntax match   Special "[][&()*,.:;<=>{}]\+"
syntax region  Error   start="[\t ]\+$" end="$"

let b:current_syntax = "phdl"
