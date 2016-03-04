SUMMARY = "Test vectors for the cryptography package."
SECTION = "devel/python"
LICENSE = "Apache-2.0 | BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8c3617db4fb6fae01f1d253ab91511e4"
DEPENDS = "python-cryptography"
SRCNAME = "cryptography_vectors"

SRC_URI = "https://pypi.python.org/packages/source/c/cryptography-vectors/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

SRC_URI[md5sum] = "3db975361a72134297932896752ae72c"
SRC_URI[sha256sum] = "a928dff1af28551ae89376d6789a6754af658f89613e7f9e0e491d643f4e1222"

inherit setuptools
