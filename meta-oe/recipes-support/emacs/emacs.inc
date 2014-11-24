DESCRIPTION = "Emacs"
HOMEPAGE = "http://www.gnu.org/software/emacs/"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
SECTION = "editor"
# and it needs to run some generated binaries..
DEPENDS += "qemu-native"

DEPENDS +=" liblockfile ncurses"

X11DEPENDS = " \
    libice libsm atk cairo dbus expat libffi fontconfig freetype gconf giflib \
    jpeg xz pixman libpng librsvg tiff libcroco \
    libx11 libxau libxcomposite libxcursor libxdamage libxdmcp libxext libxfixes \
    libxft libxpm libxrandr libxrender \
    gdk-pixbuf glib-2.0 gtk+ pango libxcb harfbuzz icu \
"

EXTRA_OECONF =  "--without-sound --with-crt-dir=${STAGING_LIBDIR} "

PACKAGECONFIG ??= "${@base_contains('DISTRO_FEATURES', 'x11', 'x11', '', d)}"
PACKAGECONFIG[x11] = "--with-x-toolkit=gtk,--without-x --without-dbus,${X11DEPENDS}"

inherit autotools

PACKAGES =+ "${PN}-el ${PN}-grep-changelog"

RDEPENDS_${PN}-grep-changelog += "perl"
FILES_${PN}-grep-changelog += "${bindir}/grep-changelog"

FILES_${PN}-el = "${datadir}/emacs/*/*/*.el.gz \
                  ${datadir}/emacs/*/*/*/*.el.gz"

FILES_${PN} += "${datadir}/emacs ${datadir}/icons"

FILES_${PN}-dbg += "${libexecdir}/emacs/*/*/.debug ${datadir}/emacs/*/*/.debug"

QEMUARCH= "${TARGET_ARCH}"
QEMUARCH_i486 = "i386"
QEMUARCH_i586 = "i386"
QEMUARCH_i686 = "i386"

QEMU_OPTIONS ?= ""

# Large stack is required at least on x86_64 host, otherwise random segfaults appear:
QEMU = "qemu-${QEMUARCH} ${QEMU_OPTIONS} -s 1048576 -L ${STAGING_DIR_HOST} "

export LOGNAME = "$(whoami)"

do_compile_prepend() {
    sed -i ':1;s:\(START.* \|LIB_STANDARD.* \|LIBES.* \)/usr/lib:\1${STAGING_LIBDIR}:;t1' ${S}/src/s/gnu-linux.h `find "${S}" -name Makefile`
    export LD_LIBRARY_PATH="$LD_LIBRARY_PATH:${TOOLCHAIN_PATH}/${TARGET_SYS}/lib"
# Ugly hack, see files/use-qemu.patch for more:
    ln -sf ../src/emacs lisp/emacs
    ln -sf ../src/emacs lib-src/emacs
    ln -sf ../src/emacs leim/emacs
}

do_install_append() {
    # freaks package.bbclass and whole bitbake call returns error code
    # ERROR: runstrip: ''arm-oe-linux-gnueabi-strip'  '/var/lib/jenkins/jobs/shr-core-branches/workspace/shr-core/tmp-eglibc/work/armv4t-oe-linux-gnueabi/emacs-23.4-r0/package/usr/share/emacs/23.4/etc/tutorials/TUTORIAL.ko'' strip command failed
    mv ${D}${datadir}/${BPN}/${PV}/etc/tutorials/TUTORIAL.ko ${D}${datadir}/${BPN}/${PV}/etc/tutorials/TUTORIAL.KO
    # Info dir listing isn't interesting at this point so remove it if it exists.
    if [ -e "${D}${infodir}/dir" ]; then
        rm -f ${D}${infodir}/dir
    fi
}

EXTRA_OEMAKE += 'QEMU="${QEMU}"'
