DESCRIPTION = "pyparted is a set of Python modules that provide Python programmers \
an interface to libparted, the GNU parted library for disk partitioning and \
filesystem manipulation."
SUMMARY = "Python bindings for libparted"
HOMEPAGE = "https://github.com/rhinstaller/pyparted/"
LICENSE = "GPL-2.0+"
LIC_FILES_CHKSUM = "\
    file://COPYING;md5=8ca43cbc842c2336e835926c2166c28b \
    file://src/_pedmodule.c;startline=10;endline=22;md5=ebcb25dde1ac9c46e986dec79b404e7e \
"
DEPENDS += "parted"

SRCNAME = "pyparted"
SRC_URI = "https://github.com/rhinstaller/${SRCNAME}/archive/v${PV}.tar.gz"
SRC_URI[md5sum] = "b303caf8e907a2541e71aa492494b5e5"
SRC_URI[sha256sum] = "8cbaf024fbbc73cdceab2eac0937035052da48295970fe9eaa84b19d8e353e19"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

RDEPENDS_${PN} += "python-stringold python-codecs python-math"
RDEPENDS_${PN}_class-native = ""

BBCLASSEXTEND += "native"
