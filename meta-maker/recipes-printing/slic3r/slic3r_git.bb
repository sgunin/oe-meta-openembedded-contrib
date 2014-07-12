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
LIC_FILES_CHKSUM = "file://README.md;beginline=77;endline=84;md5=4e907cb01787f6711506359a57c22961"

export SLIC3R_NO_AUTO = "1"

DEPENDS = "  libcapture-tiny-perl-native \
             libconstant-defer-perl-native \
             libencode-locale-perl-native \
	     libextutils-cppguess-perl-native \
             libextutils-parsexs-perl-native \
	     libextutils-typemaps-default-perl-native \
             libio-stringy-perl-native \
             libmath-libm-perl-native \
             libmath-planepath-perl-native \
             libmodule-build-withxspp-perl-native \
             libmoo-perl-native \
             libslic3r-xs-perl-native \
"
PACKAGES =+ "gui"
DEPENDS_${PN}-gui = " libwx-perl-native"

RECOMMENDS_${PN}-gui = " libgrowl-gntp-perl-native \
                         libwx-glcanvas-perl-native \
                         libopengl-perl-native \
"


SRC_URI = "git://github.com/alexrj/Slic3r.git"
SRCREV = "f82a8475a1ccd7ca9ebddd31d6b60953a26b5f39"

S = "${WORKDIR}/git"

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
                   libslic3r-xs-perl \
                   perl-module-time-hires \
"

RECOMMENDS += " libclass-xsaccessor-perl-native \
                libgrowl-gntp-perl-native \
                libxml-sax-expatxs-perl-native \
                libwx-perl-native \
"

BBCLASSEXTEND = "native"
