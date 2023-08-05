SUMMARY = "Modules for parsing/translating POD format documents"
DESCRIPTION = "This software distribution contains the following packages \
for using Perl5 'pod' (Plain Old Documentation).  See the 'perlpod' and \
'perlsyn' manual pages from your Perl5 distribution for more information \
about pod."

SECTION = "libs"

HOMEPAGE = "http://metapan.org/release/Pod-Parser/"

LICENSE = "Artistic-1.0 | GPL-1.0-or-later"
LIC_FILES_CHKSUM = "file://README;beginline=81;endline=108;md5=b93e564b839cf01e8979b8a028687bce"

SRC_URI = "${CPAN_MIRROR}/authors/id/M/MA/MAREKR/Pod-Parser-${PV}.tar.gz"
SRC_URI[sha256sum] = "22928a7bffe61b452c05bbbb8f5216d4b9cf9fe2a849b776c25500d24d20df7c"

S = "${WORKDIR}/Pod-Parser-${PV}"

inherit cpan ptest-perl

RDEPENDS:${PN} += " \
    perl-module-cwd \
    perl-module-file-basename \
    perl-module-file-find \
    perl-module-filehandle \
"

RDEPENDS:${PN}-ptest += " \
    perl-module-file-glob \
    perl-module-pod-checker \
    perl-module-pod-simple \
    perl-module-pod-simple-methody \
    perl-module-test \
    perl-module-test-more \
"

RPROVIDES:${PN} = " \
    libpod-find-perl \
    libpod-inputobject-perl \
    libpod-parseutils-perl \
    libpod-plaintext-perl \
    libpod-selectperl \
"

do_install_ptest:append() {
    install -m 0755 ${B}/scripts/podselect.PL ${D}${PTEST_PATH}/
    sed -i -e "1s!/usr/local/bin/perl!/usr/bin/perl!" ${D}${PTEST_PATH}/podselect.PL
    cp -r ${B}/lib ${D}${PTEST_PATH}/
}

BBCLASSEXTEND = "native"
