HOMEPAGE = "http://mesonbuild.com"
SUMMARY = "A high performance build system"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI = "https://github.com/mesonbuild/meson/releases/download/${PV}/${BP}.tar.gz"
SRC_URI[md5sum] = "394b838952d78138b3873b7a745538c1"
SRC_URI[sha256sum] = "3d160b0514ff3d25f0a47975c6f70fd82b76c589876d10413efc5e01df43e0c2"

inherit setuptools3

RDEPENDS_${PN} = "ninja python3-core python3-modules"

BBCLASSEXTEND = "native"
