SUMMARY = "UNIX Shell similar to the Korn shell"
DESCRIPTION = "Zsh is a shell designed for interactive use, although it is also a \
               powerful scripting language. Many of the useful features of bash, \
               ksh, and tcsh were incorporated into zsh; many original features were added."
HOMEPAGE = "http://www.zsh.org"
SECTION = "base/shell"

LICENSE = "zsh"
LIC_FILES_CHKSUM = "file://LICENCE;md5=1a4c4cda3e8096d2fd483ff2f4514fec"

DEPENDS = "ncurses bison-native libcap groff-native"

SRC_URI = " \
    http://www.zsh.org/pub/zsh-${PV}.tar.xz;name=zsh \
    http://www.zsh.org/pub/zsh-${PV}-doc.tar.xz;name=zsh-docs \
    file://pcre-pkgconfig.patch \
    file://configure.ac.patch \
    file://zprofile \
    file://zshrc \
    file://zsh_profile.sh \
    file://dot.zshrc \
"

SRC_URI[zsh.md5sum] = "0b80b7f64c30397cd747d97c378018af"
SRC_URI[zsh.sha256sum] = "94cbd57508287e8faa081424509738d496f5f41e32ed890e3a5498ce05d3633b"
SRC_URI[zsh-docs.md5sum] = "1724342c71a7194cdc02e22be7464ba3"
SRC_URI[zsh-docs.sha256sum] = "b8b1a40aeec852806ad2b74b0a0c534320bf517e2fe2a087c0c9d39e75dc29f1"

inherit autotools gettext update-alternatives pkgconfig

PACKAGECONFIG ??= " \
    nls pcre \
"

PACKAGECONFIG[static] =    "--disable-dynamic,--enable-dynamic,,"
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
    --enable-largefile \
"

EXTRA_OECONF_append_libc-musl = " --enable-libc-musl "

EXTRA_OEMAKE += " LLIST='-Wl,-rpath=${libdir}/${BPN}' "

ALTERNATIVE_${PN} = "sh"
ALTERNATIVE_LINK_NAME[sh] = "${base_bindir}/sh"
ALTERNATIVE_TARGET[sh] = "${base_bindir}/${BPN}"
ALTERNATIVE_PRIORITY = "80"

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
    install -d ${D}${sysconfdir}/profile.d ${D}${sysconfdir}/skel
    install -m 0644 ${WORKDIR}/zprofile ${D}${sysconfdir}/zprofile
    install -m 0644 ${WORKDIR}/zshrc ${D}${sysconfdir}/zshrc
    install -m 0644 ${WORKDIR}/zsh_profile.sh ${D}${sysconfdir}/profile.d/zsh.sh
    install -m 0644 ${WORKDIR}/dot.zshrc ${D}${sysconfdir}/skel/.zshrc

    echo '# /etc/zshenv: system-wide .zshenv file for zsh(1).' > ${D}${sysconfdir}/zshenv
    echo '# /etc/zlogin: system-wide .zlogin file for zsh(1).' > ${D}${sysconfdir}/zlogin
    echo '# /etc/zlogout: system-wide .zlogout file for zsh(1).' > ${D}${sysconfdir}/zlogout

    # install configuration examples
    install -d ${D}${datadir}/examples/${BPN}
    install -m 644 ${S}/StartupFiles/* ${D}${datadir}/examples/${BPN}
}

pkg_postinst_${PN} () {
    touch $D${sysconfdir}/shells
    grep -q "bin/sh" $D${sysconfdir}/shells || echo /bin/sh >> $D${sysconfdir}/shells
    grep -q "bin/zsh" $D${sysconfdir}/shells || echo ${base_bindir}/zsh >> $D${sysconfdir}/shells
    grep -q "bin/rzsh" $D${sysconfdir}/shells || echo ${base_bindir}/rzsh >> $D${sysconfdir}/shells
}

pkg_postrm_${PN} () {
    printf "$(grep -Ev "bin/r?zsh" $D${sysconfdir}/shells)\n" > $D${sysconfdir}/shells
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

RDEPENDS_${PN}-functions += "${PN}"
RDEPENDS_${PN}-examples += "${PN}"
RRECOMMENDS_${PN} += "${PN}-functions"
RRECOMMENDS_${PN}-doc += "${PN}-examples"
