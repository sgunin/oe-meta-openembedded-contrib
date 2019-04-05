SUMMARY = "libisofs is a library to create an ISO-9660 filesystem"
HOMEPAGE = "http://libburnia-project.org/"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=9ac2e7cff1ddaf48b6eab6028f23ef88"

SRC_URI = "http://files.libburnia-project.org/releases/${BP}.tar.gz \
           file://includes.patch"
SRC_URI[md5sum] = "6207379ff84e6988b479e09a8698fb6d"
SRC_URI[sha256sum] = "da5f9de3085dd7e34f3bfa73bef4f6380253b839c7aa9aa8ae66f1e1a61a3400"

# includes broken. also needs acinclude symbol fix
inherit autotools pkgconfig

DEPENDS = "acl zlib"
