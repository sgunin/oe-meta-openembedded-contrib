SUMMARY = "Javascript bindings for GNOME"
LICENSE = "MIT & LGPL-2.0-or-later"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=8dcea832f6acf45d856abfeb2d51ec48 \
    file://LICENSES/MIT.txt;md5=38aa75cf4c4c87f018227d5ec9638d75 \
    file://LICENSES/LGPL-2.0-or-later.txt;md5=6d2d9952d88b50a51a5c73dc431d06c7 \
"

GNOMEBASEBUILDCLASS = "meson"

DEPENDS = "mozjs gtk+3 webkitgtk"

inherit gnomebase gsettings gobject-introspection vala gettext features_check upstream-version-is-even pkgconfig

SRC_URI[archive.sha256sum] = "4b0629341a318a02374e113ab97f9a9f3325423269fc1e0b043a5ffb01861c5f"

# gobject-introspection is mandatory and cannot be configured
REQUIRED_DISTRO_FEATURES = "gobject-introspection-data"
UNKNOWN_CONFIGURE_WHITELIST:append = " --enable-introspection --disable-introspection"

EXTRA_OECONF = " \
    --without-dbus-tests \
    --disable-installed-tests \
"

FILES:${PN} += "${datadir}/gjs-1.0/lsan"

PACKAGES =+ "${PN}-valgrind"
FILES:${PN}-valgrind = "${datadir}/gjs-1.0/valgrind"
RDEPENDS:${PN}-valgrind += "valgrind"

# Valgrind not yet available on rv32/rv64
RDEPENDS:${PN}-valgrind:remove:riscv32 = "valgrind"
RDEPENDS:${PN}-valgrind:remove:riscv64 = "valgrind"
