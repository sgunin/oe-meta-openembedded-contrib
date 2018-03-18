SUMMARY = "Text processing system for documentation"
HOMEPAGE = "http://docutils.sourceforge.net"
SECTION = "devel/python"
LICENSE = "PSF & BSD-2-Clause & GPLv3"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=35a23d42b615470583563132872c97d6"

SRC_URI[md5sum] = "c53768d63db3873b7d452833553469de"
SRC_URI[sha256sum] = "51e64ef2ebfb29cae1faa133b3710143496eca21c530f3f71424d77687764274"

inherit pypi distutils

BBCLASSEXTEND = "native"

