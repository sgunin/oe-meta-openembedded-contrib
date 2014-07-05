SUMMARY = "Role::Tiny - Roles. Like a nouvelle cousine portion size of Moose."
DESCRIPTION = "\"Role::Tiny\" is a minimalist role composition tool."

SECTION = "libs"

HOMEPAGE = "https://metacpan.org/pod/Devel-GlobalDestruction/"

LICENSE = "Artistic-1.0 | GPL-1.0+"
LIC_FILES_CHKSUM = "file://README;beginline=207;endline=213;md5=ed1628a1e7cc9df8d9885920b7f51a11"

SRC_URI = "${CPAN_MIRROR}/authors/id/H/HA/HAARG/Role-Tiny-${PV}.tar.gz"
SRC_URI[md5sum] = "f8c04c43b28824589f560d029e497119"
SRC_URI[sha256sum] = "b712cadb6eecb7777278be79b5ffc55b613c0e75b9872dba474179cbc91b02cd"

S = "${WORKDIR}/Role-Tiny-${PV}"

inherit cpan

RDEPENDS_${PN} = " perl-module-exporter \
"

BBCLASSEXTEND = "native"
