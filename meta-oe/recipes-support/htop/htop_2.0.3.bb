SUMMARY = "htop process monitor"
HOMEPAGE = "http://hisham.hm/htop"
SECTION = "console/utils"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=c312653532e8e669f30e5ec8bdc23be3"

DEPENDS = "ncurses"
RDEPENDS_${PN} = "ncurses-terminfo"

SRC_URI = " \
    git://github.com/hishamhm/htop.git \
    file://disable-script.patch \
    "

SRCREV = "f80e577c5973069c1c84d7435eec60adc968da82"

S = "${WORKDIR}/git"

LDFLAGS_append_libc-uclibc = " -lubacktrace"

inherit autotools pkgconfig
