SUMMARY = "Tool to assist in network address calculations for IPv4 and IPv6."
HOMEPAGE = "https://github.com/nmav/ipcalc"

SECTION = "net"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"

SRC_URI = "https://github.com/nmav/ipcalc/archive/${PV}.tar.gz;downloadfilename=ipcalc-${PV}.tar.gz"

SRC_URI[md5sum] = "edbfc4cb64632e0c4f87cf81c7d8302d"
SRC_URI[sha256sum] = "c965c1296172a6acc50d54dfe81f7e5d589f9762b5d9ae459eee00349675336b"

export USE_GEOIP = "no"

do_install() {
    install -d ${D}/${bindir}
    install -m 0755 ${S}/ipcalc ${D}/${bindir}
}
