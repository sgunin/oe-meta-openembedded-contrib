DESCRIPTION = "Generic framework for visualization and analysis of multispectral and hyperspectral data that strives to both bring new innovations in analysis capabilities and be of use in a wide range of hyperspectral data applications"
HOMEPAGE = "http://gerbilvis.org/"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"
DEPENDS = "boost qt4-x11-free tbb opencv libglu virtual/libgl"
SRCREV = "670e06da516ed51dbae75e41e043900256bdabba"

SRC_URI = "git://github.com/gerbilvis/gerbil.git"

S = "${WORKDIR}/git"

inherit distutils-base cmake qt4x11

export EXTRA_OECMAKE = "\
                        -DQT_MOC_EXECUTABLE=${OE_QMAKE_MOC} \
                        -DQT_UIC_EXECUTABLE=${OE_QMAKE_UIC} \
                        -DQT_RCC_EXECUTABLE=${OE_QMAKE_RCC} \
                        "

do_configure() {
        # Ensure we get the cmake configure and not qmake
        cmake_do_configure
}
do_install() {
        install -d ${D}${bindir}
        install -m 755 bin/gerbil ${D}${bindir}/
        install -m 755 bin/qgerbil ${D}${bindir}/
}

RDEPENDS_${PN} += "qt4-x11-free"
