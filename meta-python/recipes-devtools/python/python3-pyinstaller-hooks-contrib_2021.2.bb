# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

SUMMARY = "Community maintained hooks for PyInstaller"
HOMEPAGE = "https://github.com/pyinstaller/pyinstaller-hooks-contrib"
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   LICENSE.APL.txt
#   LICENSE
#   LICENSE.GPL.txt
LICENSE = "Apache-2.0 & GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE.APL.txt;md5=9f445e374fa8f653a9654c10468ffc36 \
                    file://LICENSE;md5=822bee463f4e00ac4478593130e95ccb \
                    file://LICENSE.GPL.txt;md5=757586685e1b7938627f468f1b05b2dc"

SRC_URI[sha256sum] = "7f5d0689b30da3092149fc536a835a94045ac8c9f0e6dfb23ac171890f5ea8f2"
SRC_URI[sha384sum] = "34b251b96d58fc6bddd335c8cf100c274476536b59da41f174e79836c0be62ae24182a8b6f025dbd39d2abba43e398ce"
SRC_URI[sha512sum] = "55e26f8d14fd7d7e8b23b5f9a2f340951b1c345d2afe83f37f33e81e738712a46c3d627b0cfe3e6816e1b1f8cb4a1d74a6b5bfc2a3c712660dfdf8d205ef9d13"

inherit pypi setuptools3

# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
RDEPENDS:${PN} += "python3-core"

BBCLASSEXTEND = "native nativesdk"
