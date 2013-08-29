SUMMARY = "The Linux CAN Sniffer"

LICENSE = "GPLv3+"
LIC_FILES_CHKSUM = "file://modeltest/LICENSE.GPL;md5=34337af480a8c452bfafe22a78fa20cb"

inherit qt4x11

DEPENDS += "qwt"

PV = "0.5+svnr${SRCPV}"
SRCREV = "50"
SRC_URI = "svn://svn.code.sf.net/p/qcanobserver;module=code;protocol=https \
           file://0001-messagebufferinterface.cpp-add-sys-socket.h-as-inclu.patch \
	   file://0001-WIP-try-to-upgrade-to-qwt-6-API.patch \
           file://0003-messagebufferinterface-include-unistd.h-for-read-wri.patch \
           file://candemo.xml"

S = "${WORKDIR}/code/"

CXXFLAGS += " -DPF_CAN=29  -DAF_CAN=PF_CAN"

do_configure_prepend() {
    sed -i -e s:/usr/include/qwt5/:${STAGING_INCDIR}:g -e 's:-L/usr/lib/:-L${STAGING_DIR_TARGET}/lib -ldl:g' *.pro
}

do_configure_append() {
    sed -i -e s:-L/usr/lib::g Makefile
}

do_install() {
    install -d ${D}${datadir}/qcanobserver
    install -d ${D}${datadir}/qcanobserver/cfg
    install -d ${D}${datadir}/qcanobserver/lib
    install -d ${D}${datadir}/qcanobserver/db

    install -m 0755 ${S}/QCanObserver ${D}${datadir}/qcanobserver

    install -m 0644 ${WORKDIR}/candemo.xml ${D}${datadir}/qcanobserver/db
    install -m 0644 ${S}/db/*.xml ${D}${datadir}/qcanobserver/db
}

FILES_${PN}-dbg += "${datadir}/qcanobserver/.debug"
