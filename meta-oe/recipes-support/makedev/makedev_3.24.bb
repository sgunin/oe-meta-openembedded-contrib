DESCRIPTION = "MAKEDEV is a script for creating the necessary static \
device nodes, usually residing in the /dev directory."
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"
SECTION = "base"
SRC_URI = "http://pkgs.fedoraproject.org/repo/pkgs/MAKEDEV/MAKEDEV-${PV}-1.tar.gz/38546d1306ead17afbc34f60c06fcb20/MAKEDEV-${PV}-1.tar.gz"
SRC_URI[md5sum] = "38546d1306ead17afbc34f60c06fcb20"
SRC_URI[sha256sum] = "554f9b4a7344addf6a7ea2264f21c726939976cfdd08520e3ed8dd38c5605ffa"

inherit autotools-brokensep pkgconfig
S = "${WORKDIR}/MAKEDEV-3.24"
do_install () {
    oe_runmake DESTDIR=${D} makedevdir=/sbin install
    rm -fr ${D}/dev
}
