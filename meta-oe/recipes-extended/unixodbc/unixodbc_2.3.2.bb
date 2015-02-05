SUMMARY = "UnixODBC is an implementation of the Open Database Connectivity standard, a database abstraction layer that allows applications to be used with many different relational databases by way of a single library."
HOMEPAGE = "http://www.unixodbc.org"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=d7b37bf80a3df5a65b355433ae36d206"

SRC_URI = "ftp://ftp.unixodbc.org/pub/unixODBC/unixODBC-${PV}.tar.gz"
SRC_URI[md5sum] = "5e4528851eda5d3d4aed249b669bd05b"
SRC_URI[sha256sum] = "9c3459742f25df5aa3c10a61429bde51a6d4f11552c03095f1d33d7eb02b5c9a"

S = "${WORKDIR}/unixODBC-${PV}"

inherit autotools

do_configure() {
    gnu-configize --force
    libtoolize --force --copy
    aclocal
    autoconf
    automake --add-missing
    oe_runconf
}

