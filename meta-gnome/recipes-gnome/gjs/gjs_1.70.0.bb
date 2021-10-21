SUMMARY = "Javascript bindings for GNOME"
LICENSE = "MIT & LGPLv2+"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=8dcea832f6acf45d856abfeb2d51ec48 \
"

GNOMEBASEBUILDCLASS = "meson"

DEPENDS = "mozjs gtk+3 dbus gobject-introspection libffi cairo"

inherit gnomebase gsettings gobject-introspection gobject-introspection-data vala gettext features_check upstream-version-is-even pkgconfig

PV .= "+git${SRCPV}"
SRCREV = "e41f247f8c170d125ce968ed236ae7249e966178"
SRC_URI = "git://gitlab.gnome.org/GNOME/gjs;protocol=https;branch=mozjs91 \
           file://0001-meson-Disable-runtime-checks.patch \
          "

S = "${WORKDIR}/git"

EXTRA_OEMESON += "-Dinstalled_tests=false -Dskip_dbus_tests=true -Dskip_gtk_tests=true -Dprofiler=disabled"

# gobject-introspection is mandatory and cannot be configured
REQUIRED_DISTRO_FEATURES = "gobject-introspection-data"

FILES:${PN} += "${datadir}/gjs-1.0/lsan"

PACKAGES =+ "${PN}-valgrind"
FILES:${PN}-valgrind = "${datadir}/gjs-1.0/valgrind"
RDEPENDS:${PN}-valgrind += "valgrind"

# Valgrind not yet available on rv32/rv64
RDEPENDS:${PN}-valgrind:remove:riscv32 = "valgrind"
RDEPENDS:${PN}-valgrind:remove:riscv64 = "valgrind"
