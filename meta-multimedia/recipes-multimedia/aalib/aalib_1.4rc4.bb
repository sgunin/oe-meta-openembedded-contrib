DESCRIPTION = "AAlib is an portable library for rendering graphics as ASCII art."
HOMEPAGE = "http://aa-project.sourceforge.net/aalib/"
SECTION = "libs"

DEPENDS = "ncurses"

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=55ca817ccb7d5b5b66355690e9abc605"

S = "${WORKDIR}/aalib-1.4.0"

SRC_URI = "${SOURCEFORGE_MIRROR}/aa-project/aalib-${PV}.tar.gz"
SRC_URI[md5sum] = "d5aa8e9eae07b7441298b5c30490f6a6"
SRC_URI[sha256sum] = "0b214b98850f559e0a9ef7282de2ff336b094e1aacedefff3ffa50f07711db58"

inherit autotools

CFLAGS_append = " -fPIC "
