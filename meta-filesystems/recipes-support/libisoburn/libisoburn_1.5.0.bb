SUMMARY = "libisofs is a library to create an ISO-9660 filesystem"
HOMEPAGE = "http://libburnia-project.org/"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=9ac2e7cff1ddaf48b6eab6028f23ef88"

SRC_URI = "http://files.libburnia-project.org/releases/${BP}.tar.gz"
SRC_URI[md5sum] = "760258ca2b7edf95109ee44de4665daf"
SRC_URI[sha256sum] = "dac1f5629c404df236453b2b6a2671473900776c6a5707e5b8acae20385c1de5"

inherit autotools lib_package pkgconfig

DEPENDS = "acl libburn libisofs"

EXTRA_OECONF = "--enable-pkg-check-modules"

do_configure_prepend() {
	touch ${S}/NEWS
}

do_install_append() {
	rm -f ${D}${bindir}/xorriso-tcltk
}
