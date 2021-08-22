# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

SUMMARY = "Python graph (network) package"
HOMEPAGE = "https://altgraph.readthedocs.io"
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   LICENSE
#   doc/license.rst
#   doc/_build/doctrees/license.doctree
#   doc/_build/html/license.html
#   doc/_build/html/_sources/license.rst.txt
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3590eb8d695bdcea3ba57e74adf8a4ed \
                    file://doc/license.rst;md5=0c55797341c5fc3ca582cd3cd01f269f \
                    file://doc/_build/doctrees/license.doctree;md5=5fc9da3f407c876564914f5e8cb674c8 \
                    file://doc/_build/html/license.html;md5=b04f1fdd0c3babb95695881346d4e28d \
                    file://doc/_build/html/_sources/license.rst.txt;md5=24f1acc425b086e31515d7f81bd2d8cd"

SRC_URI[sha256sum] = "1f05a47122542f97028caf78775a095fbe6a2699b5089de8477eb583167d69aa"
SRC_URI[sha384sum] = "736cfa8aff65aa9abfa824da758ca4b945f07696b43624e242c363c6a6b4e8fe4ee3c4c84ef58174459669410ff342ff"
SRC_URI[sha512sum] = "1f6c17f4539bc0793c24bce22dabb597aef4ad0269f755ada8a7fb472d67fe1ea8f7fc510e2f1540c28bc2717ddbd2465be7a7d5703ac285be347ed670cb1dd7"

S = "${WORKDIR}/altgraph-${PV}"

inherit pypi setuptools3

# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
RDEPENDS:${PN} += "python3-core python3-math python3-pkg-resources python3-unittest"

# WARNING: We were unable to map the following python package/module
# dependencies to the bitbake packages which include them:
#    StringIO

BBCLASSEXTEND = "native nativesdk"
