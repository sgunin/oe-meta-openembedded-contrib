SUMMARY = "ExtUtils::CppGuess - guess C++ compiler and flags"
DESCRIPTION = "ExtUtils::CppGuess attempts to guess the system's C++ \
compiler that is compatible with the C compiler that your perl was built \
with. \
It can generate the necessary options to the Module::Build constructor or \
to ExtUtils::MakeMaker's WriteMakefile function."
SECTION = "libs"

HOMEPAGE = "https://metacpan.org/release/ExtUtils-CppGuess"

LICENSE = "Artistic-1.0 | GPL-1.0+"
LIC_FILES_CHKSUM = "file://README;beginline=81;endline=84;md5=84c0390b90ea8c6702ce659b67bed699"

SRC_URI = "${CPAN_MIRROR}/authors/id/E/ET/ETJ/ExtUtils-CppGuess-${PV}.tar.gz"
SRC_URI[md5sum] = "31e2dca9b7b7c3cc57c3c234290025b1"
SRC_URI[sha256sum] = "4cc631bab662848ea7c8899e0c62cdfdb367f2fe205b5bd85dfc1082672a6ad3"

S = "${WORKDIR}/ExtUtils-CppGuess-${PV}"

inherit cpan ptest-perl

do_install_ptest() {
	cp -r ${B}/t/lib ${D}${PTEST_PATH}/t/
	cp -r ${B}/t/module ${D}${PTEST_PATH}/t/
	cp -r ${B}/blib ${D}${PTEST_PATH}
	chown -R root:root ${D}${PTEST_PATH}
}

RDEPENDS_${PN} += " \
    libcapture-tiny-perl \
    perl-module-carp \
    perl-module-exporter \
    perl-module-extutils-makemaker \
    perl-module-extutils-parsexs \
    perl-module-file-basename \
    perl-module-file-spec \
    perl-module-file-spec-functions \
    perl-module-file-temp \
    perl-module-io-file \
    perl-module-lib \
    perl-module-scalar-util \
    perl-module-strict \
    perl-module-vars \
    perl-module-warnings \
"

RDEPENDS_${PN}-ptest += " \
    gcc \
    g++ \
    libmodule-build-perl \
    perl-module-blib \
    perl-module-fatal \
    perl-module-test-more \
"

BBCLASSEXTEND = "native"
