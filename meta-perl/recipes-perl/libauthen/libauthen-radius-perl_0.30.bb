SUMMARY = "Authen::Radius - provide simple Radius client facilities"
DESCRIPTION = "The Authen::Radius module provides a simple class that \
    allows you to send/receive Radius requests/responses to/from a \
    Radius server. \
"

HOMEPAGE = "https://metacpan.org/release/Authen-Radius"
SECTION = "libs"

LICENSE = "Artistic-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=78ab6ea0cba1f1ec1680ebb149e3bc11"

SRC_URI = "${CPAN_MIRROR}/authors/id/P/PO/PORTAONE/Authen-Radius-${PV}.tar.gz \
           file://run-ptest \
"
SRC_URI[md5sum] = "1e9e6e0730472d254f79283ad3bc58ce"
SRC_URI[sha256sum] = "799ecd0f877c73326649ab5d2b6846227874d2883d4bf858f34e638b6d05b8fe"

S = "${WORKDIR}/Authen-Radius-${PV}"

inherit cpan ptest-perl

do_install_ptest() {
    cp -r ${B}/raddb ${D}${PTEST_PATH}
    chown -R root:root ${D}${PTEST_PATH}
}

RDEPENDS_${PN} += "\
    libdata-hexdump-perl \
    libnet-ip-perl \
    perl-module-constant \
    perl-module-data-dumper \
    perl-module-digest-md5 \
    perl-module-exporter \
    perl-module-filehandle \
    perl-module-io-select \
    perl-module-io-socket \
    perl-module-time-hires \
    perl-module-vars \
    perl-module-warnings \
"
RDEPENDS_${PN}-ptest += " \
    freeradius \
    libtest-nowarnings-perl \
    perl-module-config \
    perl-module-file-spec \
    perl-module-test-more \
"

BBCLASSEXTEND = "native"
