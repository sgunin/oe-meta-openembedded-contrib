SUMMARY = "event-loop neutral asynchronous API"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=bc8917ab981cfa6161dc29319a4038d9"

SRC_URI = "https://fedorahosted.org/releases/l/i/libverto/libverto-${PV}.tar.gz"
SRC_URI[md5sum] = "d4e81c21403031089d71eaab07708b89"
SRC_URI[sha256sum] = "17eca6a3855f4884e2e7095e91501767d834b3bf313a6f59a93303f54ac91c9e"

inherit autotools pkgconfig

PACKAGES_DYNAMIC += "^libverto-.*"

EXTRA_OECONF = "--with-pthread"

PACKAGECONFIG ??= "glib libevent"
PACKAGECONFIG[glib] = "--with-glib=default,--without-glib,glib-2.0"
PACKAGECONFIG[libev] = "--with-libev=default,--without-libev,libev"
PACKAGECONFIG[libevent] = "--with-libevent=default,--without-libevent,libevent"
PACKAGECONFIG[tevent] = "--with-tevent=default,--without-tevent,libtevent"

python populate_packages_prepend () {
    modules = do_split_packages(d, "${libdir}", "^libverto-(.*)\.so\..*$", "libverto-%s", "libverto module for %s", allow_links=True, prepend=True)
    #d.appendVar("RDEPENDS_" + d.getVar("PN", True), "|".join(modules))
    # BREAKS krb as it doesn't depend on a implementation
}
