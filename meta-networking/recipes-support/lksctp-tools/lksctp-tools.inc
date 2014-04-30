DESCRIPTION = "The Linux Kernel Stream Control Transmission Protocol (lksctp) project"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPLv2"

LIC_FILES_CHKSUM = " \
  file://COPYING.lib;md5=0a1b79af951c42a9c8573533fbba9a92 \
  file://COPYING;md5=0c56db0143f4f80c369ee3af7425af6e \
  "

S = "${WORKDIR}/${BPN}-${PV}"

INC_PR = "r1"

BBCLASSEXTEND = "native"

inherit autotools pkgconfig binconfig

do_install_append_virtclass-native() {
	:
}

RREPLACES_lksctp-tools = "lksctp"

LEAD_SONAME = "libsctp.so"

PACKAGES =+ "${PN}-withsctp ${PN}-utils"

FILES_${PN} = " \
  ${libdir}/libsctp.so.${SOLIBVERSION} \
  "

FILES_${PN}-withsctp = " \
  ${libdir}/lksctp-tools/libwithsctp.so.${SOLIBVERSION}"

FILES_${PN}-dev += " \
  ${libdir}/libsctp.so.${SOLIBMAJORVERSION} \
  ${libdir}/libsctp.so \
  ${libdir}/lksctp-tools/libwithsctp.so.${SOLIBMAJORVERSION} \
  ${libdir}/lksctp-tools/libwithsctp.so \
  ${datadir}/lksctp-tools/checksctp.c \
  ${datadir}/lksctp-tools/sctp_socket.c \
  ${datadir}/lksctp-tools/sctp_status.c \
  ${datadir}/lksctp-tools/sctp_bind.c \
  ${datadir}/lksctp-tools/sctp_darn.c \
  ${datadir}/lksctp-tools/sctp_load_libs.c \
  ${datadir}/lksctp-tools/sctp_sockopt.c \
  ${datadir}/lksctp-tools/sctp_socket.h \
  ${datadir}/lksctp-tools/sctp_test.c \
  ${datadir}/lksctp-tools/sctp_darn.h \
  "

FILES_${PN}-utils = " \
  ${bindir}/sctp_test \
  ${bindir}/sctp_darn \
  ${bindir}/checksctp \
  ${bindir}/withsctp  \
  ${bindir}/sctp_status \
  "
