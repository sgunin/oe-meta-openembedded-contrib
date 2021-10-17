SUMMARY = "GNOME Weather"
DESCRIPTION = "Monitor the current weather conditions for your city, or \
anywhere in the world."
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING.md;md5=a9d253a59188a900a1ec39eb401a6824"

SECTION = "x11/gnome"

GNOMEBASEBUILDCLASS = "meson"

inherit gnomebase gettext upstream-version-is-even gobject-introspection

SRC_URI[archive.sha256sum] = "e5614eb74297e072960d6447557fa9fbfccf24bfcb314944b6d976640ee62dee"

DEPENDS += "glib-2.0 glib-2.0-native gtk+3 gjs geoclue libgweather libhandy"

#FILES:${PN} += " \
#    ${datadir}/backgrounds \
#    ${datadir}/gnome-background-properties \
#"
