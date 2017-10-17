DESCRIPTION = "library to compute convex hulls, Delaunay triangulations and Voronoi diagrams."
HOMEPAGE = "http://www.qhull.org/"
SECTION = "libs"
LICENSE = "qhull"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=6cf68697da2f499f1207c84dc319b727"

SRC_URI = "http://www.qhull.org/download/qhull-2015-src-7.2.0.tgz \
           file://qhullcpp.pc \
           file://qhull.pc \
           file://qhull_r.pc \
           file://qhullstatic.pc \
           file://qhullstatic_r.pc \
          "
SRC_URI[md5sum] = "e6270733a826a6a7c32b796e005ec3dc"
SRC_URI[sha256sum] = "78b010925c3b577adc3d58278787d7df08f7c8fb02c3490e375eab91bb58a436"

CFLAGS += "-fPIC"

EXTRA_OECMAKE += "\
  -DCMAKE_SKIP_RPATH=ON \
"

inherit cmake pkgconfig

do_install_append() {
    install -d ${D}${libdir}/pkgconfig
    install -m 0644 ${WORKDIR}/qhullcpp.pc ${D}${libdir}/pkgconfig/
    install -m 0644 ${WORKDIR}/qhull.pc ${D}${libdir}/pkgconfig/
    install -m 0644 ${WORKDIR}/qhull_r.pc ${D}${libdir}/pkgconfig/
    install -m 0644 ${WORKDIR}/qhullstatic.pc ${D}${libdir}/pkgconfig/
    install -m 0644 ${WORKDIR}/qhullstatic_r.pc ${D}${libdir}/pkgconfig/
}
