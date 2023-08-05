SUMMARY = "PO for anything"
DESCRIPTION = "The po4a (PO for anything) project goal is to ease translations \
(and more interestingly, the maintenance of translations) using gettext tools \
on areas where they were not expected like documentation."
HOMEPAGE = "https://po4a.alioth.debian.org"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=a96fc9b4cc36d80659e694ea109f0325"

SRC_URI = "git://github.com/mquinson/po4a.git;protocol=https;branch=master"

# v0.49
SRCREV = "79ed87a577a543538fe39c7b60079981f5997072"

S = "${WORKDIR}/git"

DEPENDS = " \
    libmodule-build-perl-native \
    libtext-wrapi18n-perl \
    libterm-readkey-perl \
    liblocale-gettext-perl \
    libunicode-linebreak-perl \
"

RDEPENDS:${PN} = " \
    perl-module-encode-encoding \
    perl-module-encode-guess \
    perl-module-file-copy \
    perl-module-getopt-long \
    perl-module-getopt-std \
    perl-module-pod-simple \
    perl-module-pod-simple-transcode \
    perl-module-pod-simple-transcodedumb \
    perl-module-pod-simple-transcodesmart \
    perl-module-pod-text \
    perl-module-time-local \
"

RRECOMMENDS:${PN} = " \
    libtext-wrapi18n-perl \
    libterm-readkey-perl \
    liblocale-gettext-perl \
    libunicode-linebreak-perl \
"

inherit cpan_build ptest-perl

RDEPENDS:${PN}-ptest += " \
    diffutils \
    gettext \
    glibc-gconv-iso8859-1 \
    glibc-charmap-iso-8859-1 \
    glibc-utils \
    libpod-parser-perl \
    perl-module-test-more \
"

do_install_ptest:prepend () {
    sed -i -e "s!../../scripts/msguntypot!/usr/bin/msguntypot!g" ${B}/t/28-msguntypot.t
    rm -rf ${B}/t/20-sgml.t
    rm -rf ${B}/t/24-tex.t
}

do_install_ptest:append () {
    ln -sf ${bindir}/po4a ${D}${PTEST_PATH}/
    ln -sf ${bindir}/po4a-gettextize ${D}${PTEST_PATH}/
    ln -sf ${bindir}/po4a-normalize ${D}${PTEST_PATH}/
    ln -sf ${bindir}/po4a-translate ${D}${PTEST_PATH}/
    ln -sf ${bindir}/po4a-updatepo ${D}${PTEST_PATH}/
}

BBCLASSEXTEND = "native"
