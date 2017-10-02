SUMMARY = "A tool for distributing file system images"
SECTION = "console/network"
HOMEPAGE = "https://github.com/systemd/casync"
LICENSE = "LGPLv2.1+"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL2.1;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://github.com/systemd/casync;protocol=https"

PV = "2+git${SRCPV}"
SRCREV = "6daefa8a008c3230495a76017eca546f6622bb1d"

S = "${WORKDIR}/git"

DEPENDS = "acl curl xz zlib openssl zstd"

inherit meson

PACKAGECONFIG ??= ""
PACKAGECONFIG[fuse] = "-Dfuse=true,-Dfuse=false,fuse"
PACKAGECONFIG[selinux] = "-Dselinux=true,-Dselinux=false,libselinux"
PACKAGECONFIG[man] = "-Dman=true,-Dman=false,python-sphinx-native"

BBCLASSEXTEND = "native nativesdk"

