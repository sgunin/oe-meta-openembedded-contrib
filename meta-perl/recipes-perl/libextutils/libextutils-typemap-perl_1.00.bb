SUMMARY = "ExtUtils::Typemap - Read/Write/Modify Perl/XS typemap files"
DESCRIPTION = "This module exists merely as a compatibility wrapper around \
\"ExtUtils::Typemaps\". In a nutshell, \"ExtUtils::Typemaps\" because the \
_Typemap_ directory in _lib/_ could collide with the _typemap_ file on \
case-insensitive file systems. \
\
The \"ExtUtils::Typemaps\" module is a part of the \"ExtUtils::ParseXS\" \
distribution and ships with the standard library of perl starting with \
perl version 5.16."

SECTION = "libs"

HOMEPAGE = "https://metapan.org/release/ExtUtils-Typemap"

LICENSE = "Artistic-1.0 | GPL-1.0+"
LIC_FILES_CHKSUM = "file://README;beginline=25;endline=29;md5=eae1222adce11c64b284ac2e2b62fb31"

SRC_URI = "${CPAN_MIRROR}/authors/id/S/SM/SMUELLER/ExtUtils-Typemap-${PV}.tar.gz"
SRC_URI[md5sum] = "a7175a06e27939a83b1b781e91c13ad0"
SRC_URI[sha256sum] = "b1b015772dbb068b93a0f6ffa02f5d94822365e6018ac5ed2bc53ca669071fc7"

S = "${WORKDIR}/ExtUtils-Typemap-${PV}"

inherit cpan

RDEPENDS_${PN} = " libextutils-typemaps-perl"

BBCLASSEXTEND = "native"
