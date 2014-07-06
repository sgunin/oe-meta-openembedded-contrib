SUMMARY = "Slic3r - G-code generator for 3D printers"
DESCRIPTION = "Slic3r takes 3D models (STL, OBJ, AMF) and converts them into \
G-code instructions for 3D printers. It's compatible with any modern printer \
based on the RepRap toolchain, including all those based on the Marlin, \
Sprinter and Repetier firmware. It also works with Mach3 and LinuxCNC \
controllers. \
"
HOMEPAGE = "http://slic3r.org/"
SECTION = "devel"

LICENSE = "AGPL-3.0 | CC-BY-3.0"
LIC_FILES_CHKSUM = "file://../README.md;beginline=77;endline=84;md5=4e907cb01787f6711506359a57c22961"

DEPENDS = "  libextutils-cppguess-perl-native \
             libcapture-tiny-perl-native \
             libmodule-build-withxspp-perl-native \
             libextutils-parsexs-perl-native \
             libextutils-typemaps-default-perl-native \
"

SRC_URI = "git://github.com/alexrj/Slic3r.git;branch=stable"
SRCREV = "f3db14bfbe258ebb67232b68cf15e56c7b30ab30"

S = "${WORKDIR}/git/xs"

inherit cpan_build

RDEPENDS_${PN} = " libencode-locale-perl \
                   libextutils-makemaker-perl \
                   libextutils-parsexs-perl \
                   perl-module-file-basename \
                   perl-module-file-spec \
                   perl-module-getopt-long \
                   libmath-planepath-perl \
                   libmodule-build-withxspp-perl \
                   libmoo-perl \
                   perl-module-scalar-util \
                   libtest-harness-perl \
                   libio-scalar-perl \
                   perl-module-time-hires \
"

#RECOMMENDS += " perl-module-class-xsaccessor \
#                perl-module-growl-gntp \
#                perl-module-xml-sax-expatxs \
#                perl-module-wx \
#"

BBCLASSEXTEND = "native"
