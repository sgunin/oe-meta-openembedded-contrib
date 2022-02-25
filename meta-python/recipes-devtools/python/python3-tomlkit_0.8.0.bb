# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

SUMMARY = "Style preserving TOML library"
HOMEPAGE = "https://github.com/sdispater/tomlkit"
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
# NOTE: Original package / source metadata indicates license is: MIT
#
# NOTE: multiple licenses have been detected; they have been separated with &
# in the LICENSE value for now since it is a reasonable assumption that all
# of the licenses apply. If instead there is a choice between the multiple
# licenses then you should change the value to separate the licenses with |
# instead of &. If there is any doubt, check the accompanying documentation
# to determine which situation is applicable.
LICENSE = "ISC & MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=31aac0dbc1babd278d5386dadb7f8e82 \
                    file://tests/toml-spec-tests/LICENSE;md5=13311e2badf243167d02d299debe64c4 \
                    file://tests/toml-test/COPYING;md5=2cd67fca932d1b1ef026fbc3d89d9b57"

SRC_URI[sha256sum] = "29e84a855712dfe0e88a48f6d05c21118dbafb283bb2eed614d46f80deb8e9a1"

S = "${WORKDIR}/tomlkit-${PV}"

inherit pypi poetry_core

# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
RDEPENDS:${PN} += "python3-core python3-datetime python3-json python3-pickle python3-pytest python3-stringold"

# WARNING: We were unable to map the following python package/module
# dependencies to the bitbake packages which include them:
#    yaml

BBCLASSEXTEND = "native nativesdk"
