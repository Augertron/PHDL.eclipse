#
# Simulator
#

database require simulator -hints {
    simulator "ncsim -gui work.board"
}

#
# groups
#
catch {group new -name {SYS Interface} -overlay 0}
catch {group new -name {TRN Rx} -overlay 0}
catch {group new -name {TRN Common} -overlay 0}
catch {group new -name {TRN Tx} -overlay 0}

group using {SYS Interface}
group set -overlay 0
group set -comment {}
group clear 0 end

group insert \
    :EP:sys_clk_c \
    :EP:sys_reset_n_c

group using {TRN Rx}
group set -overlay 0
group set -comment {}
group clear 0 end

group insert \
    :EP:trn_rbar_hit_n \
    :EP:trn_rsrc_rdy_n \
    :EP:trn_rdst_rdy_n \
    :EP:trn_rsof_n \
    :EP:trn_reof_n \
    :EP:trn_rd \
    :EP:trn_rerrfwd_n \
    :EP:trn_rsrc_dsc_n \
    :EP:trn_rnp_ok_n

group using {TRN Common}
group set -overlay 0
group set -comment {}
group clear 0 end

group insert \
    :EP:trn_clk \
    :EP:trn_reset_n \
    :EP:trn_lnk_up_n \
    :EP:trn_fc_sel \
    :EP:trn_fc_cpld \
    :EP:trn_fc_cplh \
    :EP:trn_fc_npd \
    :EP:trn_fc_nph \
    :EP:trn_fc_pd \
    :EP:trn_fc_ph

group using {TRN Tx}
group set -overlay 0
group set -comment {}
group clear 0 end

group insert \
    :EP:trn_tsrc_rdy_n \
    :EP:trn_tdst_rdy_n \
    :EP:trn_tsof_n \
    :EP:trn_teof_n \
    :EP:trn_td \
    :EP:trn_tstr_n \
    :EP:trn_terrfwd_n \
    :EP:trn_tsrc_dsc_n \
    :EP:trn_terr_drop_n \
    :EP:trn_tbuf_av \
    :EP:trn_tcfg_req_n \
    :EP:trn_tcfg_gnt_n

#
# Design Browser windows
#
if {[catch {window new WatchList -name "Design Browser 1" -geometry 700x500+0+462}] != ""} {
    window geometry "Design Browser 1" 700x500+0+462
}
window target "Design Browser 1" on
browser using {Design Browser 1}
browser set \
    -scope simulator:::EP
browser yview see simulator:::EP
browser timecontrol set -lock 0

#
# Waveform windows
#
if {[catch {window new WaveWindow -name "Waveform 1" -geometry 800x600+0+0}] != ""} {
    window geometry "Waveform 1" 800x600+0+0
}
window target "Waveform 1" on
waveform using {Waveform 1}
waveform sidebar visibility partial
waveform set \
    -primarycursor TimeA \
    -signalnames name \
    -signalwidth 175 \
    -units ns \
    -valuewidth 75
cursor set -using TimeA -time 0
cursor set -using TimeA -marching 1
waveform baseline set -time 0

set groupId [waveform add -groups {{SYS Interface}}]

set groupId [waveform add -groups {{TRN Common}}]

set groupId [waveform add -groups {{TRN Rx}}]

set groupId [waveform add -groups {{TRN Tx}}]


waveform xview limits 0 2000ns

#
# Console window
#
console set -windowname Console

