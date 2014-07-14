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

export SLIC3R_NO_AUTO = "1"
export PERL_MM_USE_DEFAULT = "1"
export PERL_AUTOINSTALL = "--skipdeps"
export PERL_MM_OPT = "INSTALLDIRS=vendor DESTDIR=${D}"
export PERL_MB_OPT = "--installdirs vendor --destdir ${D}"
export MODULEBUILDRC = "/dev/null"
export EXTRA_CPAN_BUILD_FLAGS = " --xs"

DEPENDS = "  libcapture-tiny-perl-native \
             libencode-locale-perl-native \
	     libextutils-cppguess-perl-native \
             libextutils-parsexs-perl-native \
	     libextutils-typemaps-default-perl-native \
             libio-stringy-perl-native \
             libmath-planepath-perl-native \
             libmodule-build-withxspp-perl-native \
             libmoo-perl-native \
"

SRC_URI = "git://github.com/alexrj/Slic3r.git"
SRCREV = "f82a8475a1ccd7ca9ebddd31d6b60953a26b5f39"

S = "${WORKDIR}/git/xs"

inherit cpan_build

do_configure_append() {
    if [ "${@is_target(d)}" != "yes" ]; then
        # for -native: Fix -lstdc++
        sed "s:'-lstdc++'::g" -i _build/build_params
    fi
}

do_compile_prepend() {
    if [ "${@is_target(d)}" != "yes" ]; then
        # for -native: Fix BUILD_LD=ld
        export LD=g++
        export BUILD_LD=g++
    fi
}

do_install() {
    perl Build install

    # Fix install location of Slic3r/XS.pm
    if [ "${@is_target(d)}" = "yes" ]; then
        install -d ${STAGING_LIBDIR}/perl/vendor_perl/${@get_perl_version(d)}/Slic3r
        install blib/lib/Slic3r/XS.pm ${STAGING_LIBDIR}/perl/vendor_perl/${@get_perl_version(d)}/Slic3r/XS.pm
        install -d ${STAGING_LIBDIR}/perl/vendor_perl/${@get_perl_version(d)}/auto/Slic3r
install -d ${STAGING_LIBDIR}/perl/vendor_perl/${@get_perl_version(d)}/auto/Slic3r/XS
        install blib/arch/auto/Slic3r/XS/XS.* ${STAGING_LIBDIR}/perl/vendor_perl/${@get_perl_version(d)}/auto/Slic3r/XS/
    else
        # Install in proper location
        # This might be due to a problem with Module::Build::WithXSpp
        install -d ${STAGING_LIBDIR_NATIVE}/perl-native/perl/${@get_perl_version(d)}/Slic3r
        install blib/lib/Slic3r/XS.pm ${STAGING_LIBDIR_NATIVE}/perl-native/perl/${@get_perl_version(d)}/Slic3r/XS.pm
        install -d ${STAGING_LIBDIR_NATIVE}/perl-native/perl/${@get_perl_version(d)}/auto/Slic3r
	install -d ${STAGING_LIBDIR_NATIVE}/perl-native/perl/${@get_perl_version(d)}/auto/Slic3r/XS
        install blib/arch/auto/Slic3r/XS/XS.* ${STAGING_LIBDIR_NATIVE}/perl-native/perl/${@get_perl_version(d)}/auto/Slic3r/XS/
    fi
}

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

RECOMMENDS += " libclass-xsaccessor-perl-native \
                libgrowl-gntp-perl-native \
                libxml-sax-expatxs-perl-native \
                libwx-perl-native \
"

BBCLASSEXTEND = "native"
