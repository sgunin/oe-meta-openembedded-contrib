SUMMARY = "XML::SAX- Simple API for XML"
DESCRIPTION = "XML::SAX is a SAX parser access API for Perl. It includes \
classes and APIs required for implementing SAX drivers, along with a \
factory class for returning any SAX parser installed on the user's system."

SECTION = "libs"

HOMEPAGE = "http://metapan.org/pod/XML-SAX/"

LICENSE = "Artistic-1.0 | GPL-1.0+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=65c4cd8f39c24c7135ed70dacbcb09e3"

SRC_URI = "${CPAN_MIRROR}/authors/id/G/GR/GRANTM/XML-SAX-${PV}.tar.gz"
SRC_URI[md5sum] = "290f5375ae87fdebfdb5bc3854019f24"
SRC_URI[sha256sum] = "32b04b8e36b6cc4cfc486de2d859d87af5386dd930f2383c49347050d6f5ad84"

S = "${WORKDIR}/XML-SAX-${PV}"

inherit cpan

DEPENDS_${PN} = " perl-module-file-temp-native \
                  libxml-namespacesupport-perl-native \
                  libxml-sax-base-perl-native \
"

BBCLASSEXTEND = "native"
