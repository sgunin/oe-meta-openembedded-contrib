SUMMARY = "ExtUtils::XSpp - XS for C++"
DESCRIPTION = "XS++ is just a thing layer over plan XS, hence to use it \
you are supposed to know, at the very least, C++ and XS. \
\
This means that you may need typemaps for _both_ the normal XS pre-processor \
xsubpp and the XS++ pre-processor xspp."

SECTION = "libs"

HOMEPAGE = "http://metapan.org/release/ExtUtils-XSpp/"

LICENSE = "Artistic-1.0 | GPL-1.0+"
LIC_FILES_CHKSUM = "file://README;beginline=268;endline=270;md5=4e35edb4593b4e6c3310992f8cf3b530"

SRC_URI = "${CPAN_MIRROR}/authors/id/S/SM/SMUELLER/ExtUtils-XSpp-${PV}.tar.gz"
SRC_URI[md5sum] = "c44ad3281df81319d02833a4e42282ac"
SRC_URI[sha256sum] = "9176ad646729e3bd27cf7abf114bedd3424bff1ba61185cfc7d54f3a9223a8ff"

S = "${WORKDIR}/ExtUtils-XSpp-${PV}"

inherit cpan_build

DEPENDS_${PN} = " perl-module-test-base-native \
                  perl-module-test-differences-native \
"

RDEPENDS_${PN} = " libextutils-parsexs-perl \
                   libextutils-typemaps-perl \
                   perl-module-digest-md5 \
"

RPROVIDES_${PN} += " libextutils-xspp-cmd-perl \
                     libextutils-xspp-driver-perl \
                     libextutils-xspp-exception-perl \
                     libextutils-xspp-grammar-perl \
                     libextutils-xspp-lexer-perl \
                     libextutils-xspp-node-perl \
		     libextutils-xspp-node-access-perl \
		     libextutils-xspp-node-argument-perl \
		     libextutils-xspp-node-class-perl \
		     libextutils-xspp-node-comment-perl \
		     libextutils-xspp-node-constructor-perl \
		     libextutils-xspp-node-destructor-perl \
		     libextutils-xspp-node-enum-perl \
		     libextutils-xspp-node-enumvalue-perl \
		     libextutils-xspp-node-file-perl \
		     libextutils-xspp-node-function-perl \
		     libextutils-xspp-node-member-perl \
		     libextutils-xspp-node-method-perl \
		     libextutils-xspp-node-module-perl \
		     libextutils-xspp-node-package-perl \
		     libextutils-xspp-node-percany-perl \
		     libextutils-xspp-node-preprocessor-perl \
		     libextutils-xspp-node-raw-perl \
		     libextutils-xspp-node-type-perl \
                     libextutils-xspp-parser-perl \
                     libextutils-xspp-typemap-perl \
"

BBCLASSEXTEND = "native"
