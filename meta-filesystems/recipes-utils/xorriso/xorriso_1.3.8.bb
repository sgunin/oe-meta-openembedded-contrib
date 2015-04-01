DESCRIPTIONS = "xorriso copies file objects from POSIX compliant filesystems into Rock Ridge enhanced ISO 9660 filesystems and allows session-wise manipulation of such filesystems"

inherit autotools

DEPENDS += "attr zlib"

SRC_URI = "http://www.gnu.org/software/${BPN}/${BPN}-${PV}.tar.gz"

SRC_URI[md5sum] = "a0fc534ef8f9589282a189f0e6cdf952"
SRC_URI[sha256sum] = "901204634651533f7cbd105eab560534702458258529aac4b2f0fc946992107e"

LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
LICENSE = "GPLv3"

EXTRA_OECONF = "--disable-libacl"

BBCLASSEXTEND = "nativesdk"
