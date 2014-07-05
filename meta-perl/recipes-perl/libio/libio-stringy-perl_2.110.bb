SUMMARY = "IO-stringy - I/O on in-core objects like strings and arrays"
DESCRIPTION = "This toolkit primarily provides modules for performing both \
traditional and object-oriented i/o on things *other* than normal filehandles; \
in particular, IO::Scalar, IO::ScalarArray, and IO::Lines."

HOMEPAGE = "http://www.zeegee.com/products/IO-stringy/"
SECTION = "devel"
LICENSE = "Artistic-1.0 | GPL-1.0+"
LIC_FILES_CHKSUM = "file://COPYING;md5=01406e4ff2e60d88d42ef1caebdd0011"


SRC_URI = "${CPAN_MIRROR}/authors/id/D/DS/DSKOLL/IO-stringy-${PV}.tar.gz"
SRC_URI[md5sum] = "2e6a976cfa5521e815c1fdf4006982de"
SRC_URI[sha256sum] = "7e3cf438b3938a2692cb502704c0bbfa2c5ec4a5071ab77906a2432126b004ee"

S = "${WORKDIR}/IO-stringy-${PV}"

inherit cpan

RPROVIDES_${PN} += " libio-atomicfile-perl \
                     libio-lines-perl \
                     libio-scalar-perl \
                     libio-scalararray-perl \
                     libio-wrap-perl \
                     libio-wraptie-perl \
"

BBCLASSEXTEND = "native"

