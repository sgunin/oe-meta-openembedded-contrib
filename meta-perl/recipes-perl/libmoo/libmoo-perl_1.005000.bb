SUMMARY = "Moo - Minimalist Object Orientation (with Moose compatibility)"
DESCRIPTION = "This module us an extremely light-weight subset of \"Moose\" \
optimised for rapid startup and \"pay only for what you use\"."

SECTION = "libs"

HOMEPAGE = "http://metapan.org/release/Moo/"

LICENSE = "Artistic-1.0 | GPL-1.0+"
LIC_FILES_CHKSUM = "file://README;beginline=724;endline=730;md5=68b146a9b70bf2d8652e47c1ae609ae6"

SRC_URI = "${CPAN_MIRROR}/authors/id/H/HA/HAARG/Moo-${PV}.tar.gz"
SRC_URI[md5sum] = "78f920761631450d9a905725968a501c"
SRC_URI[sha256sum] = "73865789520f1ab72518d3c712e79a33d283e4166be5e949bc23ab79a7184ea4"

S = "${WORKDIR}/Moo-${PV}"

inherit cpan

DEPENDS_${PN} = "  libclass-method-modifiers-perl-native \
                   libdevel-globaldestruction-perl-native \
                   libimport-into-perl-native \
                   libmodule-runtime-perl-native \
                   librole-tiny-perl-native \
                   perl-module-scalar-util-native \
                   libstrictures-perl-native \
"

BBCLASSEXTEND = "native"
