SUMMARY = "Encode::Locale - Determine the locale encoding"
AUTHOR = "Gisle Aas <gisle@activestate.com>"
HOMEPAGE = "https://metacpan.org/module/Encode::Locale"
SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-1.0+"
LIC_FILES_CHKSUM = "file://README;md5=14e8006c2134045725fd81292a323d24"

SRC_URI = "${CPAN_MIRROR}/authors/id/G/GA/GAAS/Encode-Locale-${PV}.tar.gz"
SRC_URI[md5sum] = "de8422d068634e7c1068dab4e18b452f"
SRC_URI[sha256sum] = "f76337e0933225914111fcc3319ff4db359b1abfd1aa56dff2df5378db0e2d55"

S = "${WORKDIR}/Encode-Locale-${PV}"

inherit cpan

RDEPENDS_${PN} += "libencode-perl \
                   libencode-alias-perl \
                   "

BBCLASSEXTEND = "native"
