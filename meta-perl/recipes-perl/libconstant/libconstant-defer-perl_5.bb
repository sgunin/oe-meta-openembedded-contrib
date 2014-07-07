SUMMARY = "constant::defer - constant subs with deferred value calculation"
DESCRIPTION = "\"constant::defer\" creates a subroutine which on the first \
call runs given code to calculate its value, and on the second and \
subsequent calls just returns that value, like a constant.  The value code \
is discarded once run, allowing it to be garbage collected. \
\
Deferring a calculation is good if it might take a lot of work or produce \
a big result, but is only needed sometimes or only well into a program run. \
If it's never needed then the value code never runs."

SECTION = "libs"

HOMEPAGE = "http://user42.tuxfamily.org/constant-defer/index.html"

LICENSE = "GPL-3.0+"
LIC_FILES_CHKSUM = "file://COPYING;md5=f27defe1e96c2e1ecd4e0c9be8967949"

SRC_URI = "${CPAN_MIRROR}/authors/id/K/KR/KRYDE/constant-defer-${PV}.tar.gz"
SRC_URI[md5sum] = "519232b64896395b84b41f5300d1cab3"
SRC_URI[sha256sum] = "985fe4be377dc58d424dd3e6be1cab81f7ef4a75730d99298d94476aace0d215"

S = "${WORKDIR}/constant-defer-${PV}"

inherit cpan

DEPENDS_${PN} = "  libextutils-makemaker-perl-native"

BBCLASSEXTEND = "native"
