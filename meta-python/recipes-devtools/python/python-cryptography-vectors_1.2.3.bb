SUMMARY = "Test vectors for the cryptography package."
SECTION = "devel/python"
LICENSE = "Apache-2.0 | BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8c3617db4fb6fae01f1d253ab91511e4"
DEPENDS = "python-cryptography"
SRCNAME = "cryptography_vectors"

SRC_URI = "https://pypi.python.org/packages/source/c/cryptography-vectors/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

SRC_URI[md5sum] = "3c16f3dd4dc5d38b42d889b10b8b379d"
SRC_URI[sha256sum] = "71f2757ea5444c228d7db6c3808ff658bd44a91e612820b3dc2f9daeeee30a6a"

inherit setuptools
