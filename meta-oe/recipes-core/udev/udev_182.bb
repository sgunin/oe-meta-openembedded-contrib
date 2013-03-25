DESCRIPTION = "udev is a daemon which dynamically creates and removes device nodes from \
/dev/, handles hotplug events and loads drivers at boot time."

# udev 169 and up require kernel 2.6.36 for ARM: 
# http://git.kernel.org/?p=linux/hotplug/udev.git;a=commit;h=67a77c8bf299f6264f001677becd056316ebce2f

LICENSE = "GPLv2+ & LGPLv2.1+"
LICENSE_${PN} = "GPLv2+"
LICENSE_libudev = "LGPLv2.1+"
LICENSE_libgudev = "LGPLv2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
                    file://src/COPYING;md5=17c4e5fb495e6707ac92a3864926f979 \
                    file://src/gudev/COPYING;md5=fb494485a7d0505308cb68e4997cc266"

# glib-2.0: Needed for udev-extras
# util-linux: Needed for libblkid
# kmod: needed for libkmod
DEPENDS = "gperf-native usbutils acl glib-2.0 util-linux kmod"
PR = "r2"

# version specific SRC_URI
SRC_URI = "${KERNELORG_MIRROR}/linux/utils/kernel/hotplug/${P}.tar.gz \
           file://gtk-doc.make"
SRC_URI[md5sum] = "1b964456177fbf48023dfee7db3a708d"
SRC_URI[sha256sum] = "7857ed19fafd8f3ca8de410194e8c7336e9eb8a20626ea8a4ba6449b017faba4"

# generic SRC_URI
SRC_URI += " \
       file://touchscreen.rules \
       file://modprobe.rules \
"

# Machine specific udev rules should be in their own recipe that ${PN} can add to RRECOMMENDS

inherit autotools

EXTRA_OECONF += " \
                  --disable-introspection \
                  --with-pci-ids-path=/usr/share/misc \
                  ac_cv_file__usr_share_pci_ids=no \
                  ac_cv_file__usr_share_hwdata_pci_ids=no \
                  ac_cv_file__usr_share_misc_pci_ids=yes \
                  --sbindir=${base_sbindir} \
                  --libexecdir=${base_libdir} \
                  --with-rootlibdir=${base_libdir} \
                  --with-rootprefix= \
                  --disable-gtk-doc-html \
                  --with-systemdsystemunitdir=${systemd_unitdir}/system/ \
"

do_configure_prepend() {
	cp ${WORKDIR}/gtk-doc.make ${S}
}

PACKAGES =+ "${PN}-systemd udev-consolekit udev-utils"
PACKAGES =+ "libudev libudev-dev libudev-dbg"
PACKAGES =+ "libgudev libgudev-dev libgudev-dbg"

FILES_${PN}-systemd = "${systemd_unitdir}"
RDEPENDS_${PN}-systemd += "udev"

RDEPENDS_${PN} += "udev-utils"
RPROVIDES_${PN} = "hotplug"

FILES_${PN} += "${base_libdir}/udev"
FILES_${PN}-dbg += "${libexecdir}/.debug"
FILES_${PN}-dbg += "${base_libdir}/udev/.debug/"
FILES_${PN}-dbg += "${base_libdir}/udev/.debug/*"
FILES_${PN}-dev = "${datadir}/pkgconfig/udev.pc"
FILES_libudev = "${base_libdir}/libudev.so.*"
FILES_libudev-dbg = "${base_libdir}/.debug/libudev.so.*"
FILES_libudev-dev = "${includedir}/libudev.h ${libdir}/libudev.so ${libdir}/libudev.la \
                     ${libdir}/libudev.a ${libdir}/pkgconfig/libudev.pc"
FILES_libgudev = "${base_libdir}/libgudev*.so.* ${libdir}/libgudev*.so.*"
FILES_libgudev-dbg = "${base_libdir}/.debug/libgudev*.so.* ${libdir}/.debug/libgudev*.so.*"
FILES_libgudev-dev = "${includedir}/gudev* ${libdir}/libgudev*.so ${libdir}/libgudev*.la \
                     ${libdir}/libgudev*.a ${libdir}/pkgconfig/gudev*.pc"

FILES_${PN}-consolekit += "${libdir}/ConsoleKit"
RDEPENDS_${PN}-consolekit += "${@base_contains('DISTRO_FEATURES', 'x11', 'consolekit', '', d)}"

FILES_udev-utils = "${bindir}/udevadm"

do_install () {
	install -d ${D}${usrsbindir} \
		   ${D}${sbindir}
	oe_runmake 'DESTDIR=${D}' INSTALL=install install

	install -m 0644 ${WORKDIR}/*.rules         ${D}${sysconfdir}/udev/rules.d/
}

