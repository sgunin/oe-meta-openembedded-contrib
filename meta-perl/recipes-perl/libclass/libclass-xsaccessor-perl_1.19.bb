SUMMARY = "Class::XSAccessor - Generate fast XS accessors without runtime compilation"
DESCRIPTION = "Class::XSAccessor implements fast read, write and read/write \
accessors in XS. Additionally, it can provide predicates such as \
\"has_foo()\" for testing whether the attribute \"foo\" exists in the object \
(which is different from \"is defined within the object\"). It only works \
with objects that are implemented as ordinary hashes."

SECTION = "libs"

HOMEPAGE = "https://metacpan.org/pod/Class-XSAccessor/"

LICENSE = "Artistic-1.0 | GPL-1.0+"
LIC_FILES_CHKSUM = "file://README;beginline=173;endline=178;md5=191d949028e266de4be5f0364f547d32"

SRC_URI = "${CPAN_MIRROR}/authors/id/S/SM/SMUELLER/Class-XSAccessor-${PV}.tar.gz"
SRC_URI[md5sum] = "5c5dea74f00ad37c5119dd22b28a5563"
SRC_URI[sha256sum] = "99c56b395f1239af19901f2feeb125d9ecb4e351a0d80daa9529211a4700a6f2"

S = "${WORKDIR}/Class-XSAccessor-${PV}"

inherit cpan

DEPENDS_${PN} = " perl-module-time-hires-native \
                  perl-module-xsloader-native \
"

BBCLASSEXTEND = "native"
