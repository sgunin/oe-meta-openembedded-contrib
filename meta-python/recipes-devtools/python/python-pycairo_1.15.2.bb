SUMMARY = "Python bindings for the Cairo canvas library"
HOMEPAGE = "http://cairographics.org/pycairo"
BUGTRACKER = "http://bugs.freedesktop.org"
SECTION = "python-devel"
LICENSE = "LGPL-2.1 | MPL-1.1"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=f2e071ab72978431b294a0d696327421 \
    file://COPYING-LGPL-2.1;md5=fad9b3332be894bab9bc501572864b29 \
    file://COPYING-MPL-1.1;md5=bfe1f75d606912a4111c90743d6c7325"

# cairo >= 1.13.1
DEPENDS = "cairo"

SRC_URI = "git://github.com/pygobject/pycairo.git;protocol=https"
SRCREV = "03a1c0f7aa8b2edfeec8bede1e66ae3d419a06ff"

S = "${WORKDIR}/git"

inherit setuptools pkgconfig

CFLAGS += "-fPIC"

FILES_${PN}-dev += "${datadir}/include/pycairo/pycairo.h \
                    ${datadir}/lib/pkgconfig/pycairo.pc \
                   "
BBCLASSEXTEND = "native"
