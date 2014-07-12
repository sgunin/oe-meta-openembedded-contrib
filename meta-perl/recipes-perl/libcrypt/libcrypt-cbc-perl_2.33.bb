SUMMARY = "Crypt::CBC - Encrypt Data with Cipher Block Chaining Mode"
DESCRIPTION = "This module is a Perl-only implementation of the \
cryptographic cipher block chaining mode (CBC).  In combination with a \
block cipher such as DES or IDEA, you can encrypt and decrypt messages \
of arbitrarily long length.  The encrypted messages are compatible with \
the encryption format used by the \"OpenSSL\" package.\
\
To use this module, you will first create a Crypt::CBC cipher object\
with new().  At the time of cipher creation, you specify an encryption\
key to use and, optionally, a block encryption algorithm.  You will\
then call the start() method to initialize the encryption or\
decryption process, crypt() to encrypt or decrypt one or more blocks\
of data, and lastly finish(), to pad and encrypt the final block.  For\
your convenience, you can call the encrypt() and decrypt() methods to\
operate on a whole data value at once."

SECTION = "libs"

LICENSE = "Artistic-1.0 | GPL-1.0+"
LIC_FILES_CHKSUM = "file://CBC.pm;beginline=1053;endline=1058;md5=cca9581775161e16664921eafb6a69ac"

SRC_URI = "${CPAN_MIRROR}/authors/id/L/LD/LDS/Crypt-CBC-${PV}.tar.gz"
SRC_URI[md5sum] = "3db5117d60df67e3b400fe367e716be0"
SRC_URI[sha256sum] = "6a70de21b6cc7f2b100067e8e188db966e9a8001b5db6fa976e7cb5b294ae645"

S = "${WORKDIR}/Crypt-CBC-${PV}"

DEPENDS_${PN} = " perl-module-extutils-makemaker-native"

inherit cpan

RDEPENDS_${PN} = " perl-module-digest-md5"

BBCLASSEXTENDS = "native"
