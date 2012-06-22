if exists("b:current_syntax")
  finish
endif

syntax clear
syntax sync fromstart

syntax keyword Keyword attr begin design device group include inst net newattr of open pin this port subdesign subinst
syntax match   Comment "//.*$"
syntax region  Comment start=/\/\*/ end=/\*\//
syntax region  String  start=/"/ skip=/\\"/ end=/"/
syntax match   Number  "\<[0-9]\+\(\.[0-9]\+\)\?\>"
syntax match   Special "[][()<>{}:;,+=.&]\+"
syntax region  Error   start="[\t ]\+$" end="$"

let b:current_syntax = "phdl"
