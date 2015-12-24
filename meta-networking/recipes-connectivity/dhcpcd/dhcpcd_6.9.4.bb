SECTION = "console/network"
SUMMARY = "dhcpcd - a DHCP client"
DESCRIPTION = "dhcpcd runs on your machine and silently configures your computer to work on the attached networks without trouble and mostly without configuration."

HOMEPAGE = "http://roy.marples.name/projects/dhcpcd/"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://dhcpcd.c;endline=26;md5=7daf225c91b8065ecc974fc594b2a7de"

SRC_URI = "http://roy.marples.name/downloads/${BPN}/${BPN}-${PV}.tar.xz \
           file://configure.patch"

SRC_URI[md5sum] = "02f5043a415cd4b6d089631a0cd95f5b"
SRC_URI[sha256sum] = "c3f3ff7473ef158a1e71db9aea7424df2c3477ad064e2b542f27948a5abc9ba0"

inherit autotools

B = "${S}"
EXTRA_OECONF = "--enable-ipv4 --enable-ipv6"
