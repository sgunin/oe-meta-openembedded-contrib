SUMMARY = "inotify command line utilities"
SECTION = "console/utils"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=ac6c26e52aea428ee7f56dc2c56424c6"

SRC_URI = "http://github.com/downloads/rvoicilas/inotify-tools/inotify-tools-${PV}.tar.gz"
SRC_URI[sha256sum] = "222bcca8893d7bf8a1ce207fb39ceead5233b5015623d099392e95197676c92f"

inherit autotools-brokensep
