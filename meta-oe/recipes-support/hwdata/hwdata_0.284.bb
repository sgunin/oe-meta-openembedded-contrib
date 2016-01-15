DESCRIPTION = "Hardware identification and configuration data"
HOMEPAGE = "http://git.fedorahosted.org/git/hwdata.git"
SECTION = "System/Base"

LICENSE = "GPL-2.0+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1556547711e8246992b999edd9445a57"

SRC_URI = "https://git.fedorahosted.org/cgit/hwdata.git/snapshot/${PN}-${PV}.tar.gz"

SRC_URI[md5sum] = "30ba61f058d2c2295fd6b3ab575eb5ce"
SRC_URI[sha256sum] = "bf08c8e6200467669ffc5919141f7a47cc70756c97b819427e60b6c1a0cdcfa6"

inherit autotools-brokensep

#PROVIDES by hwdata
# the PROVIDES rules is ignore "pciutils-ids  "
PROVIDES += "pciutils-ids"
RPROVIDES_hwdata += "pciutils-ids"


#PROVIDES by hwdata-ivi
PROVIDES += "hwdata-ivi"

#RDEPENDS of hwdata-ivi (${PN}-ivi)
RDEPENDS_${PN}-ivi += "hwdata"

do_prep() {
    cd ${S}
    chmod -Rf a+rX,u+w,g-w,o-w ${S}
}

do_patch_append() {
    bb.build.exec_func('do_prep', d)
}

do_configure() {
}

do_compile() {
    cd ${S}
    LANG=C
    export LANG
    unset DISPLAY
    LD_AS_NEEDED=1; export LD_AS_NEEDED ;
	
    autotools_do_configure
}

do_install() {
    export RPM_BUILD_ROOT=${D}
    cd ${S}
    LANG=C
    export LANG
    unset DISPLAY
    rm -rf ${D}
    mkdir -p ${D}

    oe_runmake \
        DESTDIR=${D} \
        INSTALL_ROOT=${D} \
        BINDIR=${prefix}/bin \
        install
        rm -f ${D}${infodir}/dir
        find ${D} -regex ".*\.la$" | xargs rm -f --
        find ${D} -regex ".*\.a$" | xargs rm -f --
        mkdir -p ${D}${sysconfdir}/modprobe.d
        mv ${D}${prefix}/lib/modprobe.d/dist-blacklist.conf \
        ${D}${sysconfdir}/modprobe.d/blacklist.conf
        rm -rf ${D}${prefix}/lib
        install -m644 blacklist.conf ${D}/${sysconfdir}/modprobe.d
}

PACKAGES = "${PN}-dbg ${PN}-doc ${PN}-locale"
PACKAGES += " hwdata "

