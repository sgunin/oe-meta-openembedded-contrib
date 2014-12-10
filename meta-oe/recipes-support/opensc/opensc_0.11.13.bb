SUMMARY = "Smart card library and applications"
DESCRIPTION = "OpenSC is a package for for accessing smart card devices. Basic\
functionality (e.g. SELECT FILE, READ BINARY) should work on any ISO\
7816-4 compatible smart card. Encryption and decryption using private\
keys on the smart card is possible with PKCS\
such as the FINEID (Finnish Electronic IDentity) card. Swedish Posten\
eID cards have also been confirmed to work."

HOMEPAGE = "http://www.opensc-project.org/opensc/"
SECTION = "System Environment/Libraries"

SRC_URI = " \
    ${DEBIAN_MIRROR}/main/o/${PN}/${PN}_${PV}.orig.tar.gz \
    file://libopensc.pc.in-opensc-config.in-delete-lscconf.patch \
    file://src-pkcs11-and-src-tools-Modify-Makefile.patch \
"

SRC_URI[md5sum] = "98fa151e947941f9c3f27420fdf47c11"
SRC_URI[sha256sum] = "a9a42d6d51fb500f34248fcd0d4083c99d25bc5e74df60fe4efa19b5b4e6d890"

DEPENDS = "openct pcsc-lite virtual/libiconv openssl"

LICENSE = "LGPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=7fbc338309ac38fefcd64b04bb903e34"

inherit autotools pkgconfig

EXTRA_OECONF = " \
    --disable-static \
    --enable-openct \
    --enable-doc \
    --with-plugindir=${plugindir} \
    --with-pinentry=/usr/bin/pinentry \
    --disable-nsplugin \
"

do_install() {
    rm -rf ${D} _docs
    install -d ${D}/etc
    install -d ${D}${libdir}/pkcs11
    install -dm 755 ${D}${libexecdir}
    oe_runmake install DESTDIR=${D}
    install -Dpm 644 etc/opensc.conf ${D}/etc/opensc.conf
    # use NEWS file timestamp as reference for configuration file
    touch -r ${S}/NEWS ${D}/etc/opensc.conf
    find ${D}${libdir} -type f -name "*.la" | xargs rm
    if [ -d apidocdir ]; then
        rm -rf apidocdir
    fi
    if [ -d docdir ]; then
        rm -rf docdir
    fi
    mkdir apidocdir
    mv ${D}/usr/share/doc/opensc/api.html apidocdir
    mv -T ${D}/usr/share/doc/opensc docdir
    #remove not packaged files
    rm -rf ${D}${libdir}/libopensc.a
    rm -rf ${D}${libdir}/libpkcs15init.a
    rm -rf ${D}${libdir}/libscconf.a
    rm -rf ${D}${libdir}/mozilla
    rm -rf ${D}${libdir}/onepin-opensc-pkcs11.a
    rm -rf ${D}${libdir}/opensc-pkcs11.a
    rm -rf ${D}${libdir}/pkcs11-spy.a
    #remove empty directory
    rm -rf ${D}${sbindir}
    rm -rf ${D}${libexecdir}
}

FILES_${PN} += "\
    ${libdir}/opensc-pkcs11.so \
    ${libdir}/onepin-opensc-pkcs11.so \
    ${libdir}/pkcs11-spy.so \
"
FILES_${PN}-dev += "\
    ${libdir}/pkcs11/opensc-pkcs11.so \
    ${libdir}/pkcs11/onepin-opensc-pkcs11.so \
    ${libdir}/pkcs11/pkcs11-spy.so \
"
FILES_${PN}-dbg += "\
    ${libdir}/pkcs11/.debug/opensc-pkcs11.so \
    ${libdir}/pkcs11/.debug/onepin-opensc-pkcs11.so \
    ${libdir}/pkcs11/.debug/pkcs11-spy.so \
"
