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
export PERL_MM_USE_DEFAULT = "1"
export PERL_AUTOINSTALL = "--skipdeps"
export PERL_MM_OPT = "INSTALLDIRS=vendor DESTDIR=${D}"
export PERL_MB_OPT = "--installdirs vendor --destdir ${D}"
export MODULEBUILDRC = "/dev/null"

#DEPENDS = "  libcapture-tiny-perl-native \
#             libencode-locale-perl-native \
#             libextutils-cppguess-perl-native \
#             libextutils-parsexs-perl-native \
#             libextutils-typemaps-default-perl-native \
#             libio-stringy-perl-native \
#             libmath-planepath-perl-native \
#             libmodule-build-withxspp-perl-native \
#             libmoo-perl-native \
#"

SRC_URI = "git://github.com/alexrj/Slic3r.git"
SRCREV = "f82a8475a1ccd7ca9ebddd31d6b60953a26b5f39"

S = "${WORKDIR}/git"

inherit cpan-base

do_install() {
    # Top level Build.PL does not generate a Build script
    # Hence, Slic3r.pm is not installed.
    if [ "${@is_target(d)}" = "yes" ]; then
        install -d ${STAGING_LIBDIR}/perl/vendor_perl/${@get_perl_version(d)}
        install lib/Slic3r.pm ${STAGING_LIBDIR}/perl/vendor_perl/${@get_perl_version(d)}/Slic3r.pm
    else
    # -native
        install -d ${STAGING_LIBDIR_NATIVE}/perl-native/perl/${@get_perl_version(d)}
        install lib/Slic3r.pm ${STAGING_LIBDIR_NATIVE}/perl-native/perl/${@get_perl_version(d)}/Slic3r.pm
    fi
}

RDEPENDS_${PN} = " libslic3r-xs-perl \
"

BBCLASSEXTEND = "native"
