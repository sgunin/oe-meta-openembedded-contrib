SUMMARY = "PO for anything"
DESCRIPTION = "The po4a (PO for anything) project goal is to ease translations \
(and more interestingly, the maintenance of translations) using gettext tools \
on areas where they were not expected like documentation."
HOMEPAGE = "https://po4a.alioth.debian.org"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=a96fc9b4cc36d80659e694ea109f0325"

SRC_URI = "git://github.com/mquinson/po4a.git;protocol=https;branch=master"

# v0.69
SRCREV = "1925f62d0a26c4aa0621ca0cd419f7e84ecae676"

S = "${WORKDIR}/git"

inherit cpan_build ptest-perl

DEPENDS = " \
    docbook-xsl-stylesheets-native \
    gettext-native \
    libxslt-native \
    libmodule-build-perl-native \
    liblocale-gettext-perl \
    libpod-parser-perl-native \
    libtext-wrapi18n-perl \
    libterm-readkey-perl \
    libunicode-linebreak-perl \
"

RDEPENDS:${PN} = " \
    libpod-parser-perl \
    libyaml-tiny-perl \
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
    perl-module-utf8 \
"

RRECOMMENDS:${PN} = " \
    libtext-wrapi18n-perl \
    libterm-readkey-perl \
    liblocale-gettext-perl \
    libunicode-linebreak-perl \
"

do_install_ptest:append() {
    ln -sf /usr/bin/msguntypot ${D}${PTEST_PATH}/msguntypot
    ln -sf /usr/bin/po4a ${D}${PTEST_PATH}/po4a
    ln -sf /usr/bin/po4a-gettextize ${D}${PTEST_PATH}/po4a-gettextize
    ln -sf /usr/bin/po4a-normalize ${D}${PTEST_PATH}/po4a-normalize
    ln -sf /usr/bin/po4a-translate ${D}${PTEST_PATH}/po4a-translate
    ln -sf /usr/bin/po4a-updatepo ${D}${PTEST_PATH}/po4a-updatepo
}

RDEPENDS:${PN}-ptest += " \
    diffutils \
    gettext \
    glibc-gconv-iso8859-1 \
    glibc-charmap-iso-8859-1 \
    glibc-utils \
    perl-module-file-glob \
    perl-module-lib \
    perl-module-test-more \
"

BBCLASSEXTEND = "native"
