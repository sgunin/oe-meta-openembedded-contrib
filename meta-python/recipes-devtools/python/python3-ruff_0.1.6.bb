SUMMARY = "An extremely fast Python linter and code formatter, written in Rust."
DESCRIPTION = "Ruff aims to be orders of magnitude faster than alternative \
tools while integrating more functionality behind a single, common interface.\
\
Ruff can be used to replace Flake8 (plus dozens of plugins), Black, isort, \
pydocstyle, pyupgrade, autoflake, and more, all while executing tens or \
hundreds of times faster than any individual tool."
HOMEPAGE = "https://docs.astral.sh/ruff/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=74857962302335464089f7fa566b7a14"

SRC_URI[sha256sum] = "1b09f29b16c6ead5ea6b097ef2764b42372aebe363722f1605ecbcd2b9207184"

S = "${WORKDIR}/ruff-${PV}"

require ${BPN}-crates.inc

inherit pypi cargo-update-recipe-crates python_maturin

