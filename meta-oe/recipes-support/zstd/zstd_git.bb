SUMMARY = "Zstandard - Fast real-time compression algorithm"
SECTION = "libs"
HOMEPAGE = "http://www.zstd.net"
LICENSE = "BSD-3-Clause | GPLv2"
LIC_FILES_CHKSUM = "file://../../COPYING;md5=39bba7d2cf0ba1036f2a6e2be52fe3f0 \
                    file://../../LICENSE;md5=c7f0b161edbe52f5f345a3d1311d0b32"

SRC_URI = "git://github.com/facebook/zstd;protocol=https"

PV = "1.3.1+git${SRCPV}"
SRCREV = "aecf3b479c45affa9fd8ead068e9160253a8ec5c"

S = "${WORKDIR}/git/build/cmake"

inherit cmake

EXTRA_OECMAKE = "-DTHREADS_PTHREAD_ARG=2"

PACKAGES =+ "${PN}-utils"
FILES_${PN}-utils = "${bindir}"

BBCLASSEXTEND = "native nativesdk"

