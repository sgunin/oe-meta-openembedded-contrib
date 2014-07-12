SUMMARY = "XML::SAX::ExpatXS - Perl SAX 2 XS extension to Expat parser"
DESCRIPTION = "XML::SAX::ExpatXS is a direct XS extension to Expat XML \
parser. It implements Perl SAX 2.1 interface. See \
http://perl-xml.sourceforge.net/perl-sax/ for Perl SAX API description. \
Any deviations from the Perl SAX 2.1 specification are considered as bugs."

SECTION = "libs"

HOMEPAGE = "http://metapan.org/pod/XML-SAX-ExpatXS/"

LICENSE = "Artistic-1.0 | GPL-1.0+"
LIC_FILES_CHKSUM = "file://lib/XML/SAX/ExpatXS.pm;beginline=345;endline=352;md5=676baa4c774c8b3f5ca6979f3022651a"

SRC_URI = "${CPAN_MIRROR}/authors/id/P/PC/PCIMPRICH/XML-SAX-ExpatXS-${PV}.tar.gz"
SRC_URI[md5sum] = "3d69bb642ea275871a2f91a08a51cd8c"
SRC_URI[sha256sum] = "1e3db191853d235c42c7d2a5dc2ea055158ff29c7d54c5c673d271cdbd43bc6a"

S = "${WORKDIR}/XML-SAX-ExpatXS-${PV}"

inherit cpan

DEPENDS_${PN} = " libxml-sax-perl-native \
"

BBCLASSEXTEND = "native"
