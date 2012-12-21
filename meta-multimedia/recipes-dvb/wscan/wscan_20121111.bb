SUMMARY = "Wscan is an ATSC/DVB-C/S/T channel scanner that doesn't require an initial frequency table"
HOMEPAGE = "http://wirbel.htpc-forum.de/w_scan/index2.html"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

SRC_URI = "http://wirbel.htpc-forum.de/w_scan/w_scan-${PV}.tar.bz2"
SRC_URI[md5sum] = "30da05747fed9988e11ebc7745f5e71f"
SRC_URI[sha256sum] = "5e51e5f1c124a8ed70608b4dbf7376adb2b1bf6a48a65b746076263b2589afe5"

S = "${WORKDIR}/w_scan-${PV}"

inherit autotools

FILES_${PN} += "${datadir}"

