SUMMARY = "Different utilities from Android"
SECTION = "console/utils"
LICENSE = "Apache-2.0 & GPL-2.0 & BSD-2-Clause & BSD-3-Clause"
LIC_FILES_CHKSUM = " \
    file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10 \
    file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6 \
    file://${COMMON_LICENSE_DIR}/BSD-2-Clause;md5=8bef8e6712b1be5aa76af1ebde9d6378 \
    file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9 \
"
DEPENDS = "libbsd libpcre zlib libcap ruby-native cmake-native ninja-native go-native libusb1 gtest"

# matches with android-9.0.0_r10
SRCREV_core = "c8a633cd4782fd594af3f06b80ba7ee780ce65d6"
SRCREV_extras = "740a3c436188f9ad615f830e599f15506962cbcd"
SRCREV_selinux = "c679e266062e711dcf892dacd9c0cb978fde5a8a"
SRCREV_f2fs-tools = "23f82306bb2ca2553afe6791be10f93e68111da9"
SRCREV_e2fsprogs = "f63aeea08e882dad0520a1df0c57e6578d738bfe"
# instead of platfrom/external/boringssl from:
# git://${ANDROID_MIRROR}/platform/external/boringssl;name=boringssl;protocol=https;nobranch=1;destsuffix=git/boringssl \
# SRCREV_boringssl = "8c2f177d0c90eac12f6bb9a264d383e8302148f1"
# we use the standalone one (because it has cmake support) with matching SRCREV from:
# https://android.googlesource.com/platform/external/boringssl/+/android-9.0.0_r10/BORINGSSL_REVISION
SRCREV_boringssl = "45210dd4e21ace9d28cb76b3f83303fcdd2efcce"
ANDROID_MIRROR = "android.googlesource.com"

SRC_URI = " \
    git://${ANDROID_MIRROR}/platform/system/core;name=core;protocol=https;nobranch=1;destsuffix=git/core \
    git://${ANDROID_MIRROR}/platform/system/extras;name=extras;protocol=https;nobranch=1;destsuffix=git/extras \
    git://${ANDROID_MIRROR}/platform/external/selinux;name=selinux;protocol=https;nobranch=1;destsuffix=git/selinux \
    git://${ANDROID_MIRROR}/platform/external/f2fs-tools;name=f2fs-tools;protocol=https;nobranch=1;destsuffix=git/f2fs-tools \
    git://${ANDROID_MIRROR}/platform/external/e2fsprogs;name=e2fsprogs;protocol=https;nobranch=1;destsuffix=git/e2fsprogs \
    git://boringssl.googlesource.com/boringssl;name=boringssl;protocol=https;nobranch=1;destsuffix=git/boringssl \
    file://fix_build_core.patch;patchdir=core \
    file://stdatomic.patch;patchdir=core \
    file://Nonnull.patch;patchdir=core \
    file://fix_build_e2fsprogs.patch;patchdir=e2fsprogs \
    file://fix_build_selinux.patch;patchdir=selinux \
    file://generate_build.rb \
"

S = "${WORKDIR}/git"

inherit systemd

SYSTEMD_SERVICE_${PN} = "android-tools-adbd.service"

# Find libbsd headers during native builds
CC_append_class-native = " -I${STAGING_INCDIR}"
CC_append_class-nativesdk = " -I${STAGING_INCDIR}"

TOOLS = "adb mke2fs.android fastboot e2fsdroid ext2simg ext4_utils mkbootimg adbd"

# Adb needs sys/capability.h, which is not available for native*
TOOLS_class-native = "fastboot ext4_utils mkbootimg"
TOOLS_class-nativesdk = "fastboot ext4_utils mkbootimg"

do_compile() {
    PKGVER=${PV} ruby ${WORKDIR}/generate_build.rb > build.ninja
    [ -d ${S}/boringssl/build ] && rm -rf ${S}/boringssl/build
    mkdir ${S}/boringssl/build && cd ${S}/boringssl/build && cmake -G Ninja -DCMAKE_MAKE_PROGRAM=ninja ..; ninja; cd -
    ninja
}

do_install() {
    if echo ${TOOLS} | grep -q "ext4_utils" ; then
        install -D -p -m0755 ${S}/system/core/libsparse/simg_dump.py ${D}${bindir}/simg_dump
        install -D -p -m0755 ${S}/system/extras/ext4_utils/mkuserimg.sh ${D}${bindir}/mkuserimg

        install -m0755 ${B}/ext4_utils/ext2simg ${D}${bindir}
        install -m0755 ${B}/ext4_utils/ext4fixup ${D}${bindir}
        install -m0755 ${B}/ext4_utils/img2simg ${D}${bindir}
        install -m0755 ${B}/ext4_utils/make_ext4fs ${D}${bindir}
        install -m0755 ${B}/ext4_utils/simg2img ${D}${bindir}
        install -m0755 ${B}/ext4_utils/simg2simg ${D}${bindir}
    fi

    if echo ${TOOLS} | grep -q "adb " ; then
        install -d ${D}${bindir}
        install -m0755 ${B}/adb/adb ${D}${bindir}
    fi

    if echo ${TOOLS} | grep -q "adbd" ; then
        install -d ${D}${bindir}
        install -m0755 ${B}/adbd/adbd ${D}${bindir}
    fi

    # Outside the if statement to avoid errors during do_package
    install -D -p -m0644 ${WORKDIR}/android-tools-adbd.service \
      ${D}${systemd_unitdir}/system/android-tools-adbd.service

    if echo ${TOOLS} | grep -q "fastboot" ; then
        install -d ${D}${bindir}
        install -m0755 ${B}/fastboot/fastboot ${D}${bindir}
    fi

    if echo ${TOOLS} | grep -q "mkbootimg" ; then
        install -d ${D}${bindir}
        install -m0755 ${B}/mkbootimg/mkbootimg ${D}${bindir}
    fi
}

PACKAGES += "${PN}-fstools"

RDEPENDS_${BPN} = "${BPN}-conf bash"

FILES_${PN}-fstools = "\
    ${bindir}/ext2simg \
    ${bindir}/ext4fixup \
    ${bindir}/img2simg \
    ${bindir}/make_ext4fs \
    ${bindir}/simg2img \
    ${bindir}/simg2simg \
    ${bindir}/simg_dump \
    ${bindir}/mkuserimg \
"

BBCLASSEXTEND = "native"
