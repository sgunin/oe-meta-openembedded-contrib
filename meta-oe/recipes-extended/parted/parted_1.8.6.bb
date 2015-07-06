SUMMARY = "The GNU disk partition manipulation program"
DESCRIPTION = "The GNU Parted program allows you to create, destroy, resize, move, \
and copy hard disk partitions. Parted can be used for creating space \
for new operating systems, reorganizing disk usage, and copying data \
to new hard disks."
HOMEPAGE = "http://www.gnu.org/software/parted"
SECTION = "Applications/System"

SRC_URI = "http://ftp.gnu.org/gnu/parted/parted-1.8.6.tar.bz2 \
	   file://1000parted-1.8.6-warnings1.patch \
	   file://1001parted-1.8.6-notransname1.patch \
	   file://1002parted-1.8.6-off-by-one1.patch \
	   file://1003parted-1.8.6-primary-boundary1.patch \
	   file://1004parted-1.8.6-xvd1.patch \
	   file://1005parted-1.8.6-devmapper-header1.patch \
	   file://7000no_effect_macro1.patch \
           file://ui.c-fix-build-error.patch \
	   "

SRC_URI[md5sum] = "03c967ae0e915e08da90605d68ba93d7"
SRC_URI[sha256sum] = "82d94c9bb58cccd1eacfc5ff3a9331d179cc26d8fbe00c451e2c84feb6d23408"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=eb723b61539feef013de476e68b5c50a"

inherit autotools gettext pkgconfig

DEPENDS = "lvm2 readline"

EXTRA_OECONF = "--enable-device-mapper \
	        --disable-selinux \
	        --disable-static \
	        --sbindir=${sbindir} \
	        --disable-Werror \
	        --disable-rpath \
	        "
EXTRA_OEMAKE = "DESTDIR=${D}"

do_configure_prepend() {
	# ltmain.sh will set rpath to path on host.
	for l in `find ${S} -name "ltmain\.sh"` ; do
		sed -i -e 's/\$compile_rpath//g' \
		       -e 's/\$finalize_rpath//g' ${l}
	done

	# FIXME: Some option may be needed by EXTRA_OECONF.
	sed -i 's/ac_cv_func_malloc_0_nonnull=no/ac_cv_func_malloc_0_nonnull=yes/g' ${S}/configure
	sed -i 's/ac_cv_func_calloc_0_nonnull=no/ac_cv_func_calloc_0_nonnull=yes/g' ${S}/configure
	sed -i 's/ac_cv_func_memcmp_working=no/ac_cv_func_memcmp_working=yes/g' ${S}/configure
	sed -i 's/ac_cv_func_realloc_0_nonnull=no/ac_cv_func_realloc_0_nonnull=yes/g' ${S}/configure
}

do_configure() {
	oe_runconf
}

do_install_append() {
	/bin/rm -rf ${D}/${libdir}/*.la
	/bin/rm -rf ${D}/usr/share/info/dir
	/bin/rm -fr ${D}/usr/bin
}

