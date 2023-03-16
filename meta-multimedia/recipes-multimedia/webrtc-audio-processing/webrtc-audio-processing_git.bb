DESCRIPTION = "Audio processing bits of the WebRTC reference implementation"
HOMEPAGE = "https://www.freedesktop.org/software/pulseaudio/webrtc-audio-processing/"
SECTION = "audio"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=da08a38a32a340c5d91e13ee86a118f2"

DEPENDS = "abseil-cpp"

DEPENDS:append:libc-musl = " libexecinfo"
LDFLAGS:append:libc-musl = " -lexecinfo"

inherit meson pkgconfig

PV = "1.0+git${SRCPV}"
SRCREV = "ca1186946d3c9d08229c02cc7a46c3caf766ca2e"
SRC_URI = "git://gitlab.freedesktop.org/pulseaudio/webrtc-audio-processing.git;protocol=https;branch=master \
    file://0001-file_utils.h-Fix-build-with-gcc-13.patch \
    file://0002-Fix-return-type-errors.patch \
"
S = "${WORKDIR}/git"
