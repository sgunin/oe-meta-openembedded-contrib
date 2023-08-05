SUMMARY = "Read/Write YAML files with as little code as possible"
DESCRIPTION = "This software distribution contains the following packages \
for using Perl5 'pod' (Plain Old Documentation).  See the 'perlpod' and \
'perlsyn' manual pages from your Perl5 distribution for more information \
about pod."

SECTION = "libs"

HOMEPAGE = "http://metapan.org/release/YAML-Tiny/"

LICENSE = "Artistic-1.0 | GPL-1.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=be0637a0bcf879c59e74549fd7ee8496"

SRC_URI = "${CPAN_MIRROR}/authors/id/E/ET/ETHER/YAML-Tiny-${PV}.tar.gz"
SRC_URI[sha256sum] = "7b38ca9f5d3ce24230a6b8bdc1f47f5b2db348e7f7f9666c26f5955636e33d6c"

S = "${WORKDIR}/YAML-Tiny-${PV}"

inherit cpan

RDEPENDS:${PN} += " \
    perl-module-b \
    perl-module-carp \
    perl-module-exporter \
    perl-module-fcntl \
    perl-module-scalar-util \
"

BBCLASSEXTEND = "native"
