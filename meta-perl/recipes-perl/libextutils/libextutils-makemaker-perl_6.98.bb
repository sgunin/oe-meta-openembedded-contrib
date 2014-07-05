SUMMARY = "ExtUtils::MakeMaker - Create a module Makefile"
DESCRIPTION = "This utility is designed to write a Makefile for an extension \
module from a Makefile.PL. It is based on the Makefile.SH model provided by \
Andy Dougherty and the perl5-porters."
SECTION = "libs"

HOMEPAGE = "http://metapan.org/release/ExtUtils-MakeMaker/"

LICENSE = "Artistic-1.0 | GPL-1.0+"
LIC_FILES_CHKSUM = "file://META.json;md5=eec3b6484e62d92a0547f61391a37f08"

SRC_URI = "${CPAN_MIRROR}/authors/id/B/BI/BINGOS/ExtUtils-MakeMaker-${PV}.tar.gz"
SRC_URI[md5sum] = "3eb83b59e33159ecc700bf60ac3c357a"
SRC_URI[sha256sum] = "2eb023189e5fa6b9dcc66858b1fde953d1f1b86f971ec5ab42dd36c172da63ef"

S = "${WORKDIR}/ExtUtils-MakeMaker-${PV}"

inherit cpan

RDEPENDS_${PN} = " perl-module-dirhandle \
                   perl-module-file-basename \
                   perl-module-file-spec \
                   perl-module-pod-man \
"

BBCLASSEXTEND = "native"
