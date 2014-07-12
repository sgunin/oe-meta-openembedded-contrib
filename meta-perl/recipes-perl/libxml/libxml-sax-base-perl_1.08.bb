SUMMARY = "XML::SAX::Base- Base class SAX Drivers and Filters"
DESCRIPTION = "This module has a very simple task - to be a base class \
for PerlSAX drivers and filters. It's default behaviour is to pass the \
input directly to the output unchanged. It can be useful to use this \
module as a base class so you don't have to, for example, implement the \
characters() callback.\
\
The main advantages that it provides are easy dispatching of events the \
right way (ie it takes care for you of checking that the handler has \
implemented that method, or has defined an AUTOLOAD), and the guarantee \
that filters will pass along events that they aren't implementing to \
handlers downstream that might nevertheless be interested in them."

SECTION = "libs"

HOMEPAGE = "http://metapan.org/pod/XML-SAX-Base/"

LICENSE = "Artistic-1.0 | GPL-1.0+"
LIC_FILES_CHKSUM = "file://dist.ini;md5=bf28ad127cb82ea88636e2bcfcbb2883"

SRC_URI = "${CPAN_MIRROR}/authors/id/G/GR/GRANTM/XML-SAX-Base-${PV}.tar.gz"
SRC_URI[md5sum] = "38c8c3247dfd080712596118d70dbe32"
SRC_URI[sha256sum] = "666270318b15f88b8427e585198abbc19bc2e6ccb36dc4c0a4f2d9807330219e"

S = "${WORKDIR}/XML-SAX-Base-${PV}"

inherit cpan

BBCLASSEXTEND = "native"
