SUMMARY = "Function returning \"${^GLOBAL_PHASE} eq \'DESTRUCT\'\""
DESCRIPTION = "Perl's global destruction is a little trick to deal with \
WRT finalizers because it's not ordered and objects can sometimes disappear."

SECTION = "libs"

HOMEPAGE = "https://metacpan.org/pod/Devel-GlobalDestruction/"

LICENSE = "Artistic-1.0 | GPL-1.0+"
LIC_FILES_CHKSUM = "file://META.json;md5=1aefa6b98f5c3b1625f9e5f8588f14cc"

SRC_URI = "${CPAN_MIRROR}/authors/id/H/HA/HAARG/Devel-GlobalDestruction-${PV}.tar.gz"
SRC_URI[md5sum] = "87382bd2f512b0703dd55da6b2b16ec4"
SRC_URI[sha256sum] = "98a5b7668fc710e4c7ebe8860508fbebeea830eab6243d21ed8d7ac293278a70"

S = "${WORKDIR}/Devel-GlobalDestruction-${PV}"

inherit cpan

RDEPENDS_${PN} = " libsub-exporter-progressive-perl \
"

BBCLASSEXTEND = "native"
