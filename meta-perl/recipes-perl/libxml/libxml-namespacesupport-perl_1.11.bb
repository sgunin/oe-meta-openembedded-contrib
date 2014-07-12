SUMMARY = "XML::NamespaceSupport - a simple generic namespace support class"
DESCRIPTION = "\
This module offers a simple to process namespaced XML names (unames)\
from within any application that may need them. It also helps maintain\
a prefix to namespace URI map, and provides a number of basic checks.\
\
The model for this module is SAX2's NamespaceSupport class, readable at\
http://www.megginson.com/SAX/Java/javadoc/org/xml/sax/helpers/NamespaceSupport.html.\
It adds a few perlisations where we thought it appropriate."

SECTION = "libs"

HOMEPAGE = "http://metapan.org/pod/XML-NamespaceSupport/"

LICENSE = "Artistic-1.0 | GPL-1.0+"
LIC_FILES_CHKSUM = "file://META.yml;md5=9aeff4167071908eadfcccc25453ff52"

SRC_URI = "${CPAN_MIRROR}/authors/id/P/PE/PERIGRIN/XML-NamespaceSupport-${PV}.tar.gz"
SRC_URI[md5sum] = "222cca76161cd956d724286d36b607da"
SRC_URI[sha256sum] = "6d8151f0a3f102313d76b64bfd1c2d9ed46bfe63a16f038e7d860fda287b74ea"

S = "${WORKDIR}/XML-NamespaceSupport-${PV}"

inherit cpan

BBCLASSEXTEND = "native"
