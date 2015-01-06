SUMMARY = "Delivery framework for general Input Method configuration"
DESCRIPTION = "IMSettings is a framework that delivers Input Method \
settings and applies the changes so they take effect \
immediately without any need to restart applications \
or the desktop. \
This package contains the core DBus services and some utilities."
HOMEPAGE = "http://code.google.com/p/imsettings/"
SECTION = "Applications/System"

inherit autotools gtk-doc

SRC_URI = "https://bitbucket.org/tagoh/imsettings/downloads/${BPN}-${PV}.tar.bz2 \
           file://multi-line-ACLOCAL_AMFLAGS-isnot-supported-by-autoreconf.patch \
           file://gtk-is-required-by-notify.patch"

SRC_URI[md5sum] = "81ceddbbb443c101d7993a60c5ce6223"
SRC_URI[sha256sum] = "0d40099e93eb82bd35c29322df374297ae3286b5879b21f5056c8d4b5b7577dd"

LICENSE = "LGPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=2d5025d4aa3495befef8f17206a5b0a1"

EXTRA_OECONF = "--with-xinputsh=50-xinput.sh \
                --disable-static \
               "

DEPENDS = "gtk+ gconf libnotify dbus-glib libgxim"

FILES_${PN} += "${datadir}/dbus-1/*"
