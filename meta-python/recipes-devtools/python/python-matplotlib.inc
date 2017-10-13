DESCRIPTION = "matplotlib is a python 2D plotting library which produces publication quality figures in a variety of hardcopy formats"
SECTION = "devel/python"
LICENSE = "PSF"
LIC_FILES_CHKSUM = "file://LICENSE/LICENSE;md5=afec61498aa5f0c45936687da9a53d74"

SRC_URI[md5sum] = "cd26ba402c5ead6b0ecc00072f6617b4"
SRC_URI[sha256sum] = "725a3f12739d133adfa381e1b33bd70c6f64db453bfc536e148824816e568894"

DEPENDS += "freetype \
	    libagg \
            libpng \
	    ${PYTHON_PN}-cycler \
            ${PYTHON_PN}-dateutil \
	    ${PYTHON_PN}-numpy \
	    ${PYTHON_PN}-numpy-native \
	    ${PYTHON_PN}-pycairo \
	    ${PYTHON_PN}-pytz \
	    qhull \
	    "
RDEPENDS_${PN} = "freetype \
		  libagg \
                  libpng \
                  ${PYTHON_PN}-core \
		  ${PYTHON_PN}-cycler \
		  ${PYTHON_PN}-dateutil \
		  ${PYTHON_PN}-distutils \
		  ${PYTHON_PN}-numpy \
		  ${PYTHON_PN}-pycairo \
		  ${PYTHON_PN}-pyparsing \
		  ${PYTHON_PN}-pytz \
		  qhull \
		  "

# Use common directory for python2/python3 patches
FILESEXTRAPATHS_prepend := "${THISDIR}/python-matplotlib:"
#file://fix_setupext.patch 
SRC_URI += " \
	    file://run-ptest \
	    file://pytest.ini \
	    "

S = "${WORKDIR}/matplotlib-${PV}"

EXTRA_OECONF = "--with-python-includes=${STAGING_INCDIR}/../"

inherit pypi pkgconfig

export MATPLOTLIB_DIR="${libdir}/${PYTHON_DIR}/site-packages/matplotlib"

# Supported backends, one of: Agg, Cairo, GTK, GTKAgg, GTKCairo,
# GTK3Agg, GTK3Cairo, MacOSX, Pdf, Ps, Qt4Agg, Qt5Agg, SVG, TkAgg,
# WX, WXAgg.
#
# NOTE: not all of these have been implemented in OE, yet
PACKAGECONFIG ??= "Cairo"
PACKAGECONFIG[Agg] = ",,libagg"
PACKAGECONFIG[Cairo] = ",,${PYTHON_PN}-pycairo-native,${PYTHON_PN}-pycairo"
PACKAGECONFIG[Qt4Agg] = ",,${PYTHON_PN}-pyqt4 libagg"
PACKAGECONFIG[Qt5Agg] = ",,${PYTHON_PN}-pyqt5 libagg"
# NOTE:
#   oe-core does not build _tkinter module for python*
#   so python*-tkinter module is actually non-functional,
#   since http://git.openembedded.org/openembedded-core/commit/?id=8cc5e36cd7978186d5ea1fe8af2f2bd6b3df8885
PACKAGECONFIG[TkAgg] = ",,${PYTHON_PN}-tkinter tk tk-lib libagg"
PACKAGECONFIG[docs] = "--enable-docs,--disable-docs, \
                       ${PYTHON_PN}-sphinx \
                       ${PYTHON_PN}-colorspacious \
                       ${PYTHON_PN}-ipython \
                       ${PYTHON_PN}-mock \
                       ${PYTHON_PN}-numpydoc \
                       ${PYTHON_PN}-pillow \
                       ${PYTHON_PN}-scipy \
                       ${PYTHON_PN}-sphinx-gallery"

python do_write_setup_cfg() {
    conf=(d.getVar('PACKAGECONFIG', True) or "").split()
    bb.debug(1, "PACKAGECONFIG=%s" % conf)
    if 'Agg' in conf:
        bb.debug(1, "Configuring Agg backend")
    if 'Cairo' in conf:
        bb.debug(1, "Configuring Cairo backend")
}

# configure the build for cross-compiling and a known supported backend
do_configure_prepend() {
    agg=False
    tkagg=False
    ignore_qt4=" --ignore tests/test_qt4.py"
    ignore_qt5=" --ignore tests/test_qt5.py"
    if ${@bb.utils.contains('PACKAGECONFIG', 'Agg', 'true', 'false', d)}; then
        backend=Agg
        agg=True
    elif ${@bb.utils.contains('PACKAGECONFIG', 'Cairo', 'true', 'false', d)}; then
        backend=Cairo
    elif ${@bb.utils.contains('PACKAGECONFIG', 'Qt4Agg', 'true', 'false', d)}; then
        backend=Qt4Agg
        agg=True
        ignore_qt4=''
    elif ${@bb.utils.contains('PACKAGECONFIG', 'Qt5Agg', 'true', 'false', d)}; then
        backend=Qt5Agg
        agg=True
        ignore_qt5=''
    elif ${@bb.utils.contains('PACKAGECONFIG', 'TkAgg', 'true', 'false', d)}; then
        backend=TkAgg
        agg=True
        tkagg=True
    fi
    cp ${S}/setup.cfg.template ${B}/setup.cfg
    sed -i -e \
        "s:#basedirlist = /usr:basedirlist = ${STAGING_EXECPREFIXDIR}:g" \
        ${B}/setup.cfg
# matplotlib wants freetype v2.6.1
# the following tries to download that version to build it
# sed -i -e "s:#local_freetype = False:local_freetype = True:g" ${B}/setup.cfg
    sed -i -e "s:#tests = False:tests = True:g" ${B}/setup.cfg
    sed -i -e "s:#agg = auto:agg = ${agg}:g" ${B}/setup.cfg
    sed -i -e "s:#tkagg = auto:tkagg = ${tkagg}:g" ${B}/setup.cfg
    sed -i -e "s:#backend = Agg:backend = ${backend}:g" ${B}/setup.cfg
    echo "" >> ${B}/setup.cfg
    echo "verbose = True" >> ${B}/setup.cfg
}

RDEPENDS_${PN}-ptest += " \
    libagg \
    ${PN} \
    ${PYTHON_PN}-mock \
    ${PYTHON_PN}-nose \
    ${PYTHON_PN}-pytest \
"

addtask do_write_setup_cfg after do_configure before do_populate_lic

inherit ptest

do_install_ptest_prepend() {
    sed -i -e "s:\@MATPLOTLIB_DIR\@:${MATPLOTLIB_DIR}:g" ${WORKDIR}/run-ptest
    sed -i -e "s:\@MATPLOTLIB_DIR\@:${MATPLOTLIB_DIR}:g" ${WORKDIR}/pytest.ini
}

do_install_ptest() {
    install -m 0644 ${WORKDIR}/pytest.ini ${D}${MATPLOTLIB_DIR}/
}

FILES_${PN}-ptest += " \
    ${MATPLOTLIB_DIR}/sphinxext/tests \
    ${MATPLOTLIB_DIR}/tests \
    ${MATPLOTLIB_DIR}/testing \
"

BBCLASSEXTEND = "native nativesdk"
