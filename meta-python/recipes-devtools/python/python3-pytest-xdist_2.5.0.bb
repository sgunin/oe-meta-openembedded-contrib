SUMMARY = "pytest xdist plugin for distributed testing and loop-on-failing modes"
DESCRIPTION = "The pytest-xdist plugin extends pytest with new test \
execution modes, the most used being distributing tests across multiple CPUs \
to speed up test execution: \
\
pytest -n auto \
\
With this call, pytest will spawn a number of workers processes equal to \
the number of available CPUs, and distribute the tests randomly across them. \
There is also a number of distribution modes to choose from. \
\
NOTE: due to how pytest-xdist is implemented, the -s/--capture=no option does not work."
HOMEPAGE = "https://github.com/pytest-dev/pytest-xdist"
BUGTRACKER = "https://github.com/pytest-dev/pytest-xdist/issues"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=772fcdaca14b378878d05c7d857e6c3e"

SRC_URI[sha256sum] = "4580deca3ff04ddb2ac53eba39d76cb5dd5edeac050cb6fbc768b0dd712b4edf"

inherit pypi setuptools3

DEPENDS += "python3-setuptools-scm-native"

RDEPENDS:${PN} += "python3-execnet python3-pytest python3-pytest-forked"

RDEPENDS:${PN}:append:class-target = " python3-unixadmin"

BBCLASSEXTEND = "native nativesdk"
