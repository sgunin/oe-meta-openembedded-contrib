SUMMARY = "Perl extension for checking the open or closed status of a port."
DESCRIPTION = "You can use it to check if a port is open or closed for a\
given host and protocol."

HOMEPAGE = "https://metacpan.org/pod/IO-Socket-PortState"
SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-1.0+"
LIC_FILES_CHKSUM = "file://README;beginlin=26;endline=31;md5=ac0b1121d3f7342014c18236c3fe9ae9"


SRC_URI = "${CPAN_MIRROR}/authors/id/D/DM/DMUEY/IO-Socket-PortState-${PV}.tar.gz"
SRC_URI[md5sum] = "ba82446a68380e8bd79ab49a5948d6c1"
SRC_URI[sha256sum] = "9b6272699d2afd6f65aaa118e2613da28a9f3ba7a80c30bd0cfb16619db131bc"

S = "${WORKDIR}/IO-Socket-PortState-${PV}"

inherit cpan

RDEPENDS_${PN} = "perl-module-io-socket-inet"

BBCLASSEXTEND = "native"

