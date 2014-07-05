SUMMARY = "Encode - character encodings"
DESCRIPTION = "The \"Encode\" module provides the interfaces between Perl's strings and the rest of the system.  Perl strings are \
       sequences of characters. \ 
       See \"perldoc Encode\" for the rest of the story"
AUTHOR = "Dan Kogai <dankogai+cpan@gmail.com>"
HOMEPAGE = "https://metacpan.org/release/Encode"
SECTION = "lib"
LICENSE = "Artistic-1.0 | GPL-1.0+"
LIC_FILES_CHKSUM = "file://META.json;md5=18e34a7b096de96d3a8abb3f11682df7"

SRC_URI = "${CPAN_MIRROR}/authors/id/D/DA/DANKOGAI/Encode-${PV}.tar.gz"
SRC_URI[md5sum] = "566e9a270470135f90df5fb3804a67a1"
SRC_URI[sha256sum] = "e86e66121a4a98f614374e2a928de46a0c3e3f0506ee96354c185e0d1c432fd1"

S = "${WORKDIR}/Encode-${PV}"

inherit cpan

RPROVIDES_${PN} += "libencode-alias-perl \
                    libencode-byte-perl \
                    libencode-cjkconstants-perl \
                    libencode-cn-perl \
                    libencode-cn-hz-perl \
                    libencode-config-perl \
                    libencode-ebcdic-perl \
                    libencode-encoder-perl \
                    libencode-encoding-perl \
                    libencode-gsm0338-perl \
                    libencode-guess-perl \
                    libencode-jp-perl \
                    libencode-jp-h2z-perl \
                    libencode-jp-jis7-perl \
                    libencode-kr-perl \
                    libencode-kr-2022_kr-perl \
                    libencode-mime-header-perl \
                    libencode-mime-name-perl \
                    libencode-symbol-perl \
                    libencode-tw-perl \
                    libencode-unicode--perl \
                    libencode-unicode-utf7-perl \
                    libencoding-perl \
                    libencode-internal-perl \
                    libencode-mime-header-iso_2022_jp-perl \
                    libencode-utf8-perl \
                    libencode-utf_ebcdic-perl \
                    "
 
BBCLASSEXTEND = "native"
