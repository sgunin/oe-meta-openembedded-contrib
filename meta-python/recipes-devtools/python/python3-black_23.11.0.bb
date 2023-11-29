SUMMARY = "The uncompromising code formatter."
DESCRIPTION = "Black is the uncompromising Python code formatter. By using \
it, you agree to cede control over minutiae of hand-formatting. In return, \
Black gives you speed, determinism, and freedom from pycodestyle nagging \
about formatting. You will save time and mental energy for more important \
matters.\
\
Blackened code looks the same regardless of the project you're reading. \
Formatting becomes transparent after a while and you can focus on the \
content instead.\
\
Black makes code review faster by producing the smallest diffs possible."
HOMEPAGE = "https://github.com/psf/black"
LICENSE = "MIT & PSF-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d3465a2a183908c9cb95bf490bd1e7ab \
                    file://src/blib2to3/LICENSE;md5=bbbad7490e921f9a73c0e891305cb4b3"

SRC_URI[sha256sum] = "4c68855825ff432d197229846f971bc4d6666ce90492e5b02013bcaca4d9ab05"

S = "${WORKDIR}/black-${PV}"

inherit pypi python_hatchling

DEPENDS = "\
   python3-hatch-fancy-pypi-readme-native \
   python3-hatch-vcs-native \
   python3-hatchling-native \
"

RDEPENDS:${PN} = "\
    python3-click \
    python3-mypy-extensions \
    python3-packaging \
    python3-pathspec \
    python3-platformdirs \
    python3-tomli \
    python3-typing-extensions \
"
