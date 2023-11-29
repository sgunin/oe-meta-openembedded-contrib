SUMMARY = "Pytest plugin for testing examples in docstrings and markdown files."
DESCRIPTION = "pytest-examples can:\
\
lint code examples using ruff and black\
run code examples\
run code examples and check print statements are inlined correctly in the code\
It can also update code examples in place to format them and insert or update \
print statements."
HOMEPAGE = "https://github.com/pydantic/pytest-examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4914bbb433a7975b6b5c5f1bb48bb9d0"

SRC_URI[sha256sum] = "5d34d22e689aca2bbad8dd6b7cdcc9d0107e2942853b3154f3a3c68d145d91c5"

inherit pypi python_hatchling

S = "${WORKDIR}/pytest_examples-${PV}"
PYPI_ARCHIVE_NAME = "pytest_examples-${PV}.${PYPI_PACKAGE_EXT}"

RDEPENDS:${PN} += "\
    python3-black \
    python3-ruff \
    "
