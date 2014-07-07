SUMMARY = "Math::Libm - Perl extension for the C math library, libm"
DESCRIPTION = "This module is a translation of the C math.h file."

SECTION = "libs"

HOMEPAGE = "https://metacpan.org/pod/Math-Libm"

# Author email Daniel S. Lewart <d-lewart@uiuc.edu> is undeliverable :(
# Attempted email to lewart@illinois.edu on July 7, 2014
AUTHOR = "Daniel S. Lewart"
LICENSE = "No copyright provided (all rights reserved)"
LIC_FILES_CHKSUM = "file://README;md5=e4ac3d364d7932443c14ec0d78b21ab1"

SRC_URI = "${CPAN_MIRROR}/authors/id/D/DS/DSLEWART/Math-Libm-${PV}.tar.gz"
SRC_URI[md5sum] = "26a4ce8fe507d04c7d40b9eadac428ae"
SRC_URI[sha256sum] = "bfd309f283ac8cb9bf00af8c7c3a10bf25abfd642861c2022efaff0a4a52c276"

S = "${WORKDIR}/Math-Libm-${PV}"

inherit cpan

RDEPENDS_${PN} = " perl-module-strict \
                   perl-module-carp \
                   perl-module-vars \
                   perl-module-exporter \
                   perl-module-dynaloader \
                   perl-module-autoloader \
"

BBCLASSEXTEND = "native"
