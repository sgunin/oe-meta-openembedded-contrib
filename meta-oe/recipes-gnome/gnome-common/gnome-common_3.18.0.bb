SUMMARY = "Common macros for building GNOME applications"
HOMEPAGE = "http://www.gnome.org/"
BUGTRACKER = "https://bugzilla.gnome.org/"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SECTION = "x11/gnome"
inherit gnomebase allarch

SRC_URI[archive.md5sum] = "933258d9c23e218eb6eec9cc1951b053"
SRC_URI[archive.sha256sum] = "22569e370ae755e04527b76328befc4c73b62bfd4a572499fde116b8318af8cf"

EXTRA_AUTORECONF = ""
DEPENDS = ""

FILES_${PN} += "${datadir}/aclocal"
FILES_${PN}-dev = ""

# ax_code_coverage.m4 and ax_check_enable_debug.m4 are in gnome-common only
# because older versions of autoconf-archive didn't have them yet. Now they
# are in autoconf-archive from OE-core. We depend on that below to ensure
# that recipes which only depend on gnome-common still get them.
do_install_append () {
    rm -f ${D}${datadir}/aclocal/ax_code_coverage.m4
    rm -f ${D}${datadir}/aclocal/ax_check_enable_debug.m4
}
RDEPENDS_${PN} += "autoconf-archive"
DEPENDS_append_class-native = " autoconf-archive-native"

BBCLASSEXTEND = "native"
