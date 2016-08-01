SUMMARY = "CLI for structural, content-preserving transformations on PDF files"
DESCRIPTION = "QPDF is capable of creating linearized files and encrypted files. It is also capable of \
converting PDF files with object streams to files with no compressed objects or to generate object streams \
from files that don't have them. QPDF also supports a special mode designed to allow you to edit the content \
of PDF files in a text editor."
HOMEPAGE = "http://qpdf.sourceforge.net/"

DEPENDS = "libpcre zlib"

LICENSE = "Artistic-2.0"
LIC_FILES_CHKSUM = "file://Artistic-2.0;md5=7806296b9fae874361e6fb10072b7ee3"

SRC_URI = "${SOURCEFORGE_MIRROR}/${BPN}/${BPN}/${PV}/${BP}.tar.gz"
SRC_URI[md5sum] = "e014bd3ecf1c4d1a520bbc14d84ac20e"
SRC_URI[sha256sum] = "a9fdc7e94d38fcd3831f37b6e0fe36492bf79aa6d54f8f66062cf7f9c4155233"

inherit autotools pkgconfig

EXTRA_OECONF += "--with-random=/dev/urandom"
