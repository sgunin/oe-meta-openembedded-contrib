SUMMARY = "The Mercurial distributed SCM"
HOMEPAGE = "http://mercurial.selenic.com/"
SECTION = "console/utils"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "http://mercurial.selenic.com/release/mercurial-${PV}.tar.gz"
SRC_URI[md5sum] = "c38daa0cbe264fc621dc3bb05933b0b3"
SRC_URI[sha256sum] = "cb78b16956140625266a8a6d1fadc7c868969d994086e1ec60279a66bf20bffd"

S = "${WORKDIR}/mercurial-${PV}"

inherit distutils

DEPENDS += "python-docutils-native"

RDEPENDS_${PN} += " \
    python-codecs \
    python-contextlib \
    python-crypt \
    python-debugger \
    python-io \
    python-lang \
    python-mime \
    python-netclient \
    python-re \
    python-readline \
    python-shell \
    python-stringold \
    python-textutils \
    python-threading \
    python-unixadmin \
    python-xml \
"

RDEPENDS_${PN}_class-native = ""

do_compile_append_class-target() {
    oe_runmake -C doc PREFIX=${prefix}
}

do_install_append() {
    oe_runmake -C doc install DESTDIR=${D} PREFIX=${prefix}

    install -m 755 ${S}/contrib/hg-ssh ${D}${bindir}
    install -m 755 ${S}/hgeditor ${D}${bindir}

    mkdir -p ${D}${docdir}/${BPN}
    install -m 644 ${S}/CONTRIBUTORS ${D}${docdir}/${BPN}
    install -m 644 ${S}/COPYING ${D}${docdir}/${BPN}
    install -m 644 ${S}/doc/*1.txt ${D}${docdir}/${BPN}
    install -m 644 ${S}/doc/*5.txt ${D}${docdir}/${BPN}
    install -m 644 ${S}/doc/*.html ${D}${docdir}/${BPN}
    install -m 644 ${S}/doc/style.css ${D}${docdir}/${BPN}
    install -m 644 ${S}/contrib/logo-droplets.svg ${D}${docdir}/${BPN}

    mkdir -p ${D}${docdir}/${BPN}/examples
    install -m 755 ${S}/hgweb.cgi ${D}${docdir}/${BPN}/examples
    install -m 755 ${S}/contrib/hgweb.fcgi ${D}${docdir}/${BPN}/examples
    install -m 644 ${S}/contrib/hgweb.wsgi ${D}${docdir}/${BPN}/examples
}

BBCLASSEXTEND = "native nativesdk"
