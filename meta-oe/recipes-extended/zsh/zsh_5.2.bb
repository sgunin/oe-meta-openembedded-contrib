SUMMARY = "UNIX Shell similar to the Korn shell"
DESCRIPTION = "Zsh is a shell designed for interactive use, although it is also a \
               powerful scripting language. Many of the useful features of bash, \
               ksh, and tcsh were incorporated into zsh; many original features were added."
HOMEPAGE = "http://www.zsh.org"
SECTION = "base/shell"

LICENSE = "zsh"
LIC_FILES_CHKSUM = "file://LICENCE;md5=b7bc853894664be455a922db9805288e"

DEPENDS = "ncurses bison-native libcap groff-native"

SRC_URI = " \
    http://www.zsh.org/pub/zsh-${PV}.tar.xz;name=zsh \
    http://www.zsh.org/pub/zsh-${PV}-doc.tar.xz;name=zsh-docs \
    file://pcre-pkgconfig.patch \
    file://zsh_profile.sh \
    file://dot.zshrc \
"

SRC_URI[zsh.md5sum] = "afe96fde08b70e23c1cab1ca7a68fb34"
SRC_URI[zsh.sha256sum] = "f17916320ffaa844bbd7ce48ceeb5945fc5f3eff64b149b4229bbfbdf3795a9d"
SRC_URI[zsh-docs.md5sum] = "873f1ade1fa5d0d15f9cba16d3ba5f98"
SRC_URI[zsh-docs.sha256sum] = "328352cf3d5d0ec4b6e31dcefd25ff5b4c0e6b8077d1fe84448ebb50d6ada52a"

inherit autotools gettext update-alternatives pkgconfig

PACKAGECONFIG ??= "static \
    ${@bb.utils.contains('DISTRO_FEATURES', 'largefile', 'largefile', '', d)} \
"

PACKAGECONFIG[static] =    "--disable-dynamic,--enable-dynamic,,"
PACKAGECONFIG[largefile] = "--enable-largefile,--disable-largefile,,"
PACKAGECONFIG[maildir] =   "--enable-maildir-support,--disable-maildir-support,,"
PACKAGECONFIG[nls] =       "--enable-locale,--disable-locale,,"
PACKAGECONFIG[pcre] =      "--enable-pcre,--disable-pcre,libpcre,"
PACKAGECONFIG[gdbm] =      "--enable-gdbm,--disable-gdbm,gdbm,"
PACKAGECONFIG[secure] =    "--enable-zsh-mem --enable-zsh-secure-free,--disable-zsh-mem --disable-zsh-secure-free,,"

CACHED_CONFIGUREVARS = " zsh_cv_shared_environ=yes "

EXTRA_OECONF = " \
    --bindir=${base_bindir} \
    --enable-etcdir=${sysconfdir} \
    --enable-fndir=${datadir}/${BPN}/${PV}/functions \
    --enable-site-fndir=${datadir}/${BPN}/site-functions \
    --with-term-lib='ncursesw ncurses' \
    --with-tcsetpgrp \
    --enable-cap \
    --enable-multibyte \
"

EXTRA_OECONF_append_libc-musl = " --enable-libc-musl "

EXTRA_OEMAKE += " LLIST='-Wl,-rpath=${libdir}/${BPN}' "

ALTERNATIVE_${PN} = "sh"
ALTERNATIVE_LINK_NAME[sh] = "${base_bindir}/sh"
ALTERNATIVE_TARGET[sh] = "${base_bindir}/${BPN}"
ALTERNATIVE_PRIORITY = "80"

export AUTOHEADER = "true"

do_configure () {
    gnu-configize --force ${S}
    (cd ${S}; autoconf -I ${ACLOCALDIR}; autoheader -f -I ${ACLOCALDIR})
    touch ${S}/stamp-h.in
    oe_runconf
}

do_install() {
    oe_runmake 'DESTDIR=${D}' install.bin install.modules install.fns install.runhelp
    oe_runmake 'DESTDIR=${D}' install.man || true

    # Info dir listing isn't interesting at this point so remove it if it exists.
    if [ -e "${D}${infodir}/dir" ]; then
        rm -f ${D}${infodir}/dir
    fi

    # Remove versioned zsh binary
    rm -f ${D}${base_bindir}/${BPN}-${PV} || true

    # Set up restricted shells
    ln -sf ${BPN} ${D}${base_bindir}/rzsh

    # install etc files
    install -d ${D}${sysconfdir}/profile.d
    install -m 0644 ${WORKDIR}/zsh_profile.sh ${D}${sysconfdir}/profile.d
    install -d ${D}${sysconfdir}/skel
    install -m 0644 ${WORKDIR}/dot.zshrc ${D}${sysconfdir}/skel/.zshrc

    # install configuration examples
    install -d ${D}${datadir}/examples/${BPN}
    install -m 644 ${S}/StartupFiles/* ${D}${datadir}/examples/${BPN}
}

pkg_postinst_${PN} () {
    grep -q "^${base_bindir}/zsh$" $D${sysconfdir}/shells || echo ${base_bindir}/zsh >> $D${sysconfdir}/shells
}

pkg_postrm_${PN} () {
    printf "$(grep -v "^${base_bindir}/zsh$" $D${sysconfdir}/shells)\n" > $D${sysconfdir}/shells
}

PACKAGES =+ "${PN}-examples ${PN}-functions"

FILES_${PN}-examples += "${datadir}/examples/${BPN}/*"

FILES_${PN}-functions += " \
    ${datadir}/${BPN}/${PV}/scripts \
    ${datadir}/${BPN}/${PV}/functions \
    ${datadir}/${BPN}/site-functions \
"

FILES_${PN}-dbg += "\
    ${libdir}/${BPN}/.debug/*.so \
    ${libdir}/${BPN}/${PV}/zsh/.debug/*.so \
    ${libdir}/${BPN}/${PV}/zsh/db/.debug/*.so \
    ${libdir}/${BPN}/${PV}/zsh/net/.debug/*.so \
    ${libdir}/${BPN}/${PV}/zsh/param/.debug/*.so \
"

FILES_${PN}-doc += "\
    ${datadir}/${BPN}/${PV}/help \
    ${datadir}/${BPN}/${PV}/help/* \
"

FILES_${PN} += "\
    ${libdir}/${BPN}/*.so \
    ${libdir}/${BPN}/${PV}/zsh/*.so \
    ${libdir}/${BPN}/${PV}/zsh/db/*.so \
    ${libdir}/${BPN}/${PV}/zsh/net/*.so \
    ${libdir}/${BPN}/${PV}/zsh/param/*.so \
"

RRECOMMENDS_${PN} += "${PN}-functions"
RRECOMMENDS_${PN}-doc += "${PN}-examples"
