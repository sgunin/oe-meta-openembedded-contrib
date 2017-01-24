SUMMARY = "USB CEC Adaptor communication Library"
HOMEPAGE = "http://libcec.pulse-eight.com/"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=e61fd86f9c947b430126181da2c6c715"
DEPENDS = "p8platform udev lockdev ncurses python swig \
           ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'libx11 libxrandr', '', d)}"
DEPENDS_append_rpi = "${@bb.utils.contains('MACHINE_FEATURES', 'vc4graphics', '', ' userland', d)}"
SRCREV = "5250931f16122f59f0f9ef50a1f05599c69b7119"
PV = "4.0.2+git${SRCPV}"

SRC_URI = "git://github.com/Pulse-Eight/libcec.git"

S = "${WORKDIR}/git"

inherit cmake pkgconfig python-dir

# Disable python wrapper, it doesn't have crosscompiles
EXTRA_OECMAKE = "-DCMAKE_INSTALL_LIBDIR=${libdir} -DCMAKE_INSTALL_LIBDIR_NOARCH=${libdir}"

PACKAGE_BEFORE_PN = "${PYTHON_PN}-libcec cec-utils"

RDEPENDS_${PYTHON_PN}-libcec = "${PYTHON_PN}-core"

# Adapter shows up as a CDC-ACM device
RRECOMMENDS_${PN} = "kernel-module-cdc-acm"

FILES_cec-utils = "${bindir}/*"
FILES_python-libcec = "${bindir}/pyCecClient ${PYTHON_SITEPACKAGES_DIR}"
