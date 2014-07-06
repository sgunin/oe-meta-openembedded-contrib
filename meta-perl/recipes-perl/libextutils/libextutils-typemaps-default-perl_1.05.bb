SUMMARY = "ExtUtils::Typemaps::Default - A set of useful typemaps"
DESCRIPTION = "\"ExtUtils::Typemaps::Default\" is an \"ExtUtils::Typemaps\" \
subclass that provides a set of default mappsing (in addition to what perl \
provides). These default mappings are currently defined as the combination \
of the mappings provided by the following typemap classes which are provided \
in this distribution: \
\"ExtUtils::Typemaps::ObjectMap\", "\ExtUtils::Typemaps::STL\", \
\"ExtUtils::Typemaps::Basic\""

SECTION = "libs"

HOMEPAGE = "https://metapan.org/release/ExtUtils-Typemaps-Default"

LICENSE = "Artistic-1.0 | GPL-1.0+"
LIC_FILES_CHKSUM = "file://META.json;md5=1e6d5fcf59c707f0abe187adc8d63142"

SRC_URI = "${CPAN_MIRROR}/authors/id/S/SM/SMUELLER/ExtUtils-Typemaps-Default-${PV}.tar.gz"
SRC_URI[md5sum] = "346c127faf7b74bc4cfc29fa3e8e6f8d"
SRC_URI[sha256sum] = "3dfaf5837ebfdc007895bfca84c3c2e76d589a7d336400e8dfb3243d818215de"

S = "${WORKDIR}/ExtUtils-Typemaps-Default-${PV}"

inherit cpan_build

RDEPENDS_${PN} = " libextutils-typemaps-perl"

RPROVIDES_${PN} += " libextutils-typemap-basic-perl \
                     libextutils-typemap-objectmap-perl \
                     libextutils-typemap-stl-perl \
                     libextutils-typemap-stl-list-perl \
                     libextutils-typemap-stl-string-perl \
                     libextutils-typemap-stl-vector-perl \
                     libextutils-typemaps-basic-perl \
                     libextutils-typemaps-objectmap-perl \
                     libextutils-typemaps-stl-perl \
                     libextutils-typemaps-stl-list-perl \
                     libextutils-typemaps-stl-string-perl \
                     libextutils-typemaps-stl-vector-perl \
"

BBCLASSEXTEND = "native"
