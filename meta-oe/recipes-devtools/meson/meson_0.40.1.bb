HOMEPAGE = "http://mesonbuild.com"
SUMMARY = "A high performance build system"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI = "https://github.com/mesonbuild/meson/releases/download/${PV}/${BP}.tar.gz \
           file://native_bindir.patch"
SRC_URI[md5sum] = "8475b19d5f5f3bd5c40f4bb1f31b93f3"
SRC_URI[sha256sum] = "890ce46e713ea0d061f8203c99fa7d38645354a62e4c207c38ade18db852cbf5"

inherit setuptools3

RDEPENDS_${PN} = "ninja python3-core python3-modules"

BBCLASSEXTEND = "native"
