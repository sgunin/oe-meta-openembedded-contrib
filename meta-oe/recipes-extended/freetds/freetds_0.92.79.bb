SUMMARY = "FreeTDS is a set of libraries for Unix and Linux that allows your programs to natively talk to Microsoft SQL Server and Sybase databases."
HOMEPAGE = "http://www.freetds.org"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=c93c0550bd3173f4504b2cbd8991e50b \
                    file://COPYING.LIB;md5=55ca817ccb7d5b5b66355690e9abc605"

SRC_URI = "ftp://ftp.freetds.org/pub/freetds/stable/${PN}-${PV}.tar.gz"
SRC_URI[md5sum] = "b97e9bdd3f461af3e8ea559404582f70"

S = "${WORKDIR}/${PN}-${PV}"

inherit autotools

