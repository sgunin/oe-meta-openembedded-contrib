SUMMARY = "MIME::Types - Definition of MIME types"
DESCRIPTION = "MIME types are used in MIME compliant lines, for instance \
as part of e-mail and HTTP traffic, to indicate the type of content which \
is transmitted. Sometimes real knowledge about a mime-type is need.\
\n\
This module maintains a set of MIME::Type objects, which each describe \
one known mime type."
HOMEPAGE = "http://search.cpan.org/~markov/MIME-Types-${PV}"
SECTION = "libraries"

LICENSE = "Artistic-1.0|GPLv1+"
LIC_FILES_CHKSUM = "file://META.yml;beginline=11;endline=11;md5=963ce28228347875ace682de56eef8e8"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/M/MA/MARKOV/MIME-Types-${PV}.tar.gz \
           file://run-ptest \
          "
SRC_URI[sha256sum] = "0086454aec7144ddcaf842ec88e01d7fc27a61091454eb8f6f8afd568da68dd7"

S = "${WORKDIR}/MIME-Types-${PV}"

inherit cpan ptest

RDEPENDS_${PN} = "\
    perl-module-base \
    perl-module-file-basename \
    perl-module-file-spec \
    perl-module-overload \
"

RDEPENDS_${PN}-ptest = "perl-module-lib perl-module-test-more"
#RSUGGESTS_${PN}-ptest = "libmojo-base-perl"

# Latest tarball does not have bin/ dir anymore
#do_install () {
#    cpan_do_install
#    install -d ${D}${bindir}
#    install -m 755 ${S}/bin/collect-types ${D}${bindir}/collect-types
#}

do_install_ptest () {
    cp -r ${B}/t ${D}${PTEST_PATH}
}
