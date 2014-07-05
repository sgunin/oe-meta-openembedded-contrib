SUMMARY = "Import::Into - import packages into other packages"
DESCRIPTION = "Writing exporters is a pain. Some use \"Exporter\", some use \
\"Sub::Exporter\", some use \"Moose::Exporter\", some use \
\"Exporter::Declare\"... and some things are pragmas.\
\
Exporting on someone else's behalf is harder. The exporters don't provide a \
consistent API for this, and pragmas need to have their import method called \
directly, since they effect the current unit of compilation. \
\
\"Import::Into\" provides global methods to make this painless."

SECTION = "libs"

HOMEPAGE = "https://metacpan.org/pod/Import-Into/"

LICENSE = "Artistic-1.0 | GPL-1.0+"
LIC_FILES_CHKSUM = "file://README;beginline=225;endline=231;md5=cb0aa03eb2ae540cbf0bd0473db93cbe"

SRC_URI = "${CPAN_MIRROR}/authors/id/E/ET/ETHER/Import-Into-${PV}.tar.gz"
SRC_URI[md5sum] = "ec2e041b9dad3c1ee0e579e32fc5e23a"
SRC_URI[sha256sum] = "66663375617c5f41c862ae111f5ec0765033ad12b828ea1878c9f6ae4889898e"

S = "${WORKDIR}/Import-Into-${PV}"

inherit cpan

RDEPENDS_${PN} = " perl-module-strict \
                   perl-module-warnings \
"

BBCLASSEXTEND = "native"
