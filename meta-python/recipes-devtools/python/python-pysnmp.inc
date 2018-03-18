SUMMARY = "A pure-Python SNMPv1/v2c/v3 library"
DESCRIPTION = "SNMP v1/v2c/v3 engine and apps written in pure-Python. \
  Supports Manager/Agent/Proxy roles, scriptable MIBs, asynchronous \
  operation (asyncio, twisted, asyncore) and multiple transports.\
"
HOMEPAGE = "https://pypi.python.org/pypi/pysnmp"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=ade013674cd6ffd9d5d9f77089733e5e"

PYPI_PACKAGE = "pysnmp"

SRC_URI[md5sum] = "a8a5d85d7dd38ffaa6653a3b73494ce3"
SRC_URI[sha256sum] = "2f363106ad1518d9ef81c1f04b3764a77f9e5fac0303e3148ceb4261c9c6fcca"

inherit pypi

RDEPENDS_${PN} += "${PYTHON_PN}-pycrypto \
                   ${PYTHON_PN}-pyasn1 \
                   ${PYTHON_PN}-pysmi \
"

BBCLASSEXTEND += "native nativesdk"
