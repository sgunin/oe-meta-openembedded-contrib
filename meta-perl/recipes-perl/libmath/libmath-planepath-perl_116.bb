SUMMARY = "Math::PlanePath - points on a path through the 2-D plane"
DESCRIPTION = "This is a base class for some mathematical paths which \
map an integer position \"$n\" to and from coordinates \"$x,$y\" in \
the 2D plane."

SECTION = "libs"

HOMEPAGE = "http://user42.tuxfamily.org/math-planepath/index.html"

LICENSE = "GPL-3.0+"
LIC_FILES_CHKSUM = "file://COPYING;md5=f27defe1e96c2e1ecd4e0c9be8967949"

SRC_URI = "${CPAN_MIRROR}/authors/id/K/KR/KRYDE/Math-PlanePath-${PV}.tar.gz"
SRC_URI[md5sum] = "f606f26e813615e6f93db21f678a4ab1"
SRC_URI[sha256sum] = "b55f150592c157fe0cf5a897b2d929f9970e2411321c8b0ea9b5ef64689bd12b"

S = "${WORKDIR}/Math-PlanePath-${PV}"

inherit cpan

RDEPENDS_${PN} = " perl-module-constant \
                   libconstant-defer-perl \
                   perl-module-list-util \
                   libmath-libm-perl \
                   perl-module-test \
"

BBCLASSEXTEND = "native"
