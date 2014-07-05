SUMMARY = "Module::Build::WithXSpp - XS++ enhanced flavour of Module::Build"
DESCRIPTION = "This subclass of \"Module::Build\" adds some tools and \
processes to make it easier to use for wrapping C++ using XS++ \
(\"ExtUtils::XSpp\")"

SECTION = "libs"

HOMEPAGE = "http://metacpan.org/release/Module-Build-WithXSpp/"

LICENSE = "Artistic-1.0 | GPL-1.0+"
LIC_FILES_CHKSUM = "file://README;beginline=237;endline=241;md5=392b1dfedb4c03c0791ef74f8ed5d933"

SRC_URI = "${CPAN_MIRROR}/authors/id/S/SM/SMUELLER/Module-Build-WithXSpp-${PV}.tar.gz"
SRC_URI[md5sum] = "f3d6ad08127f62eed9baef131870f450"
SRC_URI[sha256sum] = "53b3c8c8fdbd50fc3dad3d19da20f1b6414ef70665b9311710c802969e746934"

S = "${WORKDIR}/Module-Build-WithXSpp-${PV}"

inherit cpan_build

RDEPENDS_${PN} = " perl-module-digest-md5 \
                   perl-module-extutils-cbuilder \
                   libextutils-cppguess-perl \
                   libextutils-parsexs-perl \
                   libextutils-xspp-perl \
                   libextutils-typemaps-perl \
                   perl-module-build \
"

BBCLASSEXTEND = "native"
