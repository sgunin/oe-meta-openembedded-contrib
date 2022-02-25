SUMMARY = "a modern parsing library"
DESCRIPTION = "Lark is a modern general-purpose parsing library for \
Python. \
\
With Lark, you can parse any context-free grammar, efficiently, with \
very little code."
HOMEPAGE = "https://github.com/lark-parser/lark"
BUGTRACKER = "https://github.com/lark-parser/lark/issues"
CHANGELOG = "https://github.com/lark-parser/lark/blob/master/CHANGELOG.md"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4a68416544bf138dbcf4dab6e9423231"

SRC_URI[sha256sum] = "2269dee215e6c689d5ce9d34fdc6e749d0c1c763add3fc7935938ebd7da159cb"

S = "${WORKDIR}/lark-${PV}"

inherit pypi setuptools3

# Uncomment this line to enable all the optional features.
#PACKAGECONFIG ?= "atomic_cache nearley regex"
PACKAGECONFIG[atomic_cache] = ",,,python3-atomicwrites"
PACKAGECONFIG[nearley] = ",,,python3-js2py"
PACKAGECONFIG[regex] = ",,,python3-regex"

RDEPENDS:${PN}:append:class-target = "\
    python3-atomicwrites \
    python3-core \
    python3-crypt \
    python3-io \
    python3-json \
    python3-logging \
    python3-math \
    python3-netclient \
    python3-pickle \
"

# WARNING: We were unable to map the following python package/module
# dependencies to the bitbake packages which include them:
#    PyInstaller.utils.hooks
#    future_builtins
#    pydot
#    typing_extensions

BBCLASSEXTEND = "native nativesdk"
