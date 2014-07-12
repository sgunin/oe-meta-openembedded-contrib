SUMMARY = "Growl::GNTP is Perl implementation of GNTP Protocol (Client Part)"
SECTION = "libs"

HOMEPAGE = "https://github.com/mattn/p5-Growl-GNTP"

LICENSE = "Artistic-1.0 | GPL-1.0+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=296c8f8250877a7c35ac8203bd5f8747"

SRC_URI = "${CPAN_MIRROR}/authors/id/M/MA/MATTN/Growl-GNTP-${PV}.tar.gz"
SRC_URI[md5sum] = "482e242fc8d274d1138c361200e0b65d"
SRC_URI[sha256sum] = "b1c9795b72c750ca6bb69cfa7e50e78e429a8e1972d7cb9ed7ee1ec769311d94"

S = "${WORKDIR}/Growl-GNTP-${PV}"

inherit cpan_build

RDEPENDS_${PN} = " libcrypt-cbc-perl \
                   libdata-uuid-perl \
                   perl-module-digest-md5 \
                   perl-module-digest-sha \
                   perl-module-filter-util-call \
                   libio-socket-portstate-perl \
"

BBCLASSEXTEND = "native"
