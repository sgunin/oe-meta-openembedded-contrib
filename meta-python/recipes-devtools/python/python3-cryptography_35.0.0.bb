SUMMARY = "Provides cryptographic recipes and primitives to python developers"
HOMEPAGE = "https://cryptography.io/"
SECTION = "devel/python"
LICENSE = "( Apache-2.0 | BSD-3-Clause ) & PSF-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=bf405a8056a6647e7d077b0e7bc36aba \
                    file://LICENSE.APACHE;md5=4e168cce331e5c827d4c2b68a6200e1b \
                    file://LICENSE.BSD;md5=5ae30ba4123bc4f2fa49aa0b0dce887b \
                    file://LICENSE.PSF;md5=43c37d21e1dbad10cddcd150ba2c0595 \
"

LDSHARED += "-pthread"

SRC_URI[sha256sum] = "9933f28f70d0517686bd7de36166dda42094eac49415459d9bdf5e7df3e0086d"

SRC_URI += " \
    file://run-ptest \
"

inherit cargo pypi python3-dir setuptools3

export PYO3_CROSS="1"
export PYO3_CROSS_PYTHON_VERSION="${PYTHON_BASEVERSION}"
export PYO3_CROSS_LIB_DIR="${STAGING_LIBDIR}"
export PYO3_CROSS_INCLUDE_DIR="${STAGING_INCDIR}"
export CARGO_BUILD_TARGET="${HOST_SYS}"
export RUSTFLAGS
export PYO3_PYTHON="${PYTHON}"
#export _PYTHON_SYSCONFIGDATA_NAME="_sysconfigdata__linux_${HOST_SYS}"

DEPENDS += " \
    ${PYTHON_PN}-asn1crypto-native \
    ${PYTHON_PN}-cffi-native \
    ${PYTHON_PN}-setuptools-rust-native \
    ${PYTHON_PN}-six-native \
"

# bitbake vendoring does not work with setuptools-rust
CARGO_DISABLE_BITBAKE_VENDORING = "1"

do_configure() {
    cargo_common_do_configure
    distutils3_do_configure
}

RDEPENDS:${PN} += " \
    ${PYTHON_PN}-asn1crypto \
    ${PYTHON_PN}-cffi \
    ${PYTHON_PN}-idna \
    ${PYTHON_PN}-setuptools \
    ${PYTHON_PN}-six \
"

RDEPENDS:${PN}:append:class-target = " \
    ${PYTHON_PN}-numbers \
    ${PYTHON_PN}-threading \
"

RDEPENDS:${PN}-ptest += " \
    ${PYTHON_PN}-bcrypt \
    ${PYTHON_PN}-cryptography-vectors \
    ${PYTHON_PN}-hypothesis \
    ${PYTHON_PN}-iso8601 \
    ${PYTHON_PN}-pretend \
    ${PYTHON_PN}-pytest \
    ${PYTHON_PN}-pytest-subtests \
    ${PYTHON_PN}-pytz \
"

inherit ptest

do_install_ptest() {
    install -d ${D}${PTEST_PATH}/tests
    cp -rf ${S}/tests/* ${D}${PTEST_PATH}/tests/
    install -d ${D}${PTEST_PATH}/tests/hazmat
    cp -rf ${S}/tests/hazmat/* ${D}${PTEST_PATH}/tests/hazmat/
    cp -r ${S}/pyproject.toml ${D}${PTEST_PATH}/
}

FILES:${PN}-dbg += " \
    ${PYTHON_SITEPACKAGES_DIR}/${SRCNAME}/hazmat/bindings/.debug \
"

BBCLASSEXTEND = "native nativesdk"
