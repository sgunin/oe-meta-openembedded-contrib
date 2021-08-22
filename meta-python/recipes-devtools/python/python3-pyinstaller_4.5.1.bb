# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

SUMMARY = "PyInstaller bundles a Python application and all its dependencies into a single package."
HOMEPAGE = "http://www.pyinstaller.org/"
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   COPYING.txt
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=752110777ecd9e72b16df0e59c1e0019"

SRC_URI[sha256sum] = "30733baaf8971902286a0ddf77e5499ac5f7bf8e7c39163e83d4f8c696ef265e"
SRC_URI[sha384sum] = "fc5cce9d0ed6f72d27f5fc15434ba7caf2b805234de3037c1801e7128140ba4b9947fe71c6f3eed29ea6ea1399a44c42"
SRC_URI[sha512sum] = "eb0b7959f3a9261204e365ab3a3a710aeaa52365c27290e71c4e81b6e14273ccf4ac619d2c4c3b37c565da0644b2797e65509ca7c4a0b81d36b6197aa89cd6df"

inherit pypi setuptools3

DEPENDS += "python3-wheel-native"

# The following configs & dependencies are from setuptools extras_require.
# These dependencies are optional, hence can be controlled via PACKAGECONFIG.
# The upstream names may not correspond exactly to bitbake package names.
#
# Uncomment this line to enable all the optional features.
#PACKAGECONFIG ?= ":python_version < "3.8" :sys_platform == "darwin" :sys_platform == "win32" encryption hook_testing"
#PACKAGECONFIG[:python_version < "3.8"] = ",,,python3-importlib-metadata"
#PACKAGECONFIG[:sys_platform == "darwin"] = ",,,python3-macholib"
#PACKAGECONFIG[:sys_platform == "win32"] = ",,,python3-pefile python3-pywin32-ctypes"
PACKAGECONFIG[encryption] = ",,,python3-tinyaes"
PACKAGECONFIG[hook_testing] = ",,,python3-execnet python3-psutil python3-pytest"

# WARNING: the following rdepends are from setuptools install_requires. These
# upstream names may not correspond exactly to bitbake package names.
RDEPENDS:${PN} += "python3-altgraph python3-pyinstaller-hooks-contrib python3-setuptools"

# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
#
# objcopy is provided by binutils
RDEPENDS:${PN} += "binutils ldd python3-core"

# WARNING: We were unable to map the following python package/module
# dependencies to the bitbake packages which include them:
#    PIL
#    StringIO
#    _frozen_importlib
#    _pkgutil
#    altgraph.ObjectGraph
#    argparse
#    ast
#    codecs
#    collections
#    contextlib
#    copy
#    ctypes
#    ctypes.macholib
#    ctypes.util
#    dis
#    dis3
#    distutils
#    distutils.ccompiler
#    distutils.msvccompiler
#    distutils.spawn
#    distutils.sysconfig
#    django
#    django.conf
#    django.core.management
#    django.utils.autoreload
#    encodings
#    fnmatch
#    glob
#    hashlib
#    imp
#    importlib
#    importlib._bootstrap_external
#    importlib.machinery
#    importlib.metadata
#    importlib.util
#    importlib_metadata
#    inspect
#    io
#    json
#    kivy.tools.packaging.pyinstaller_hooks
#    locale
#    logging
#    macholib.MachO
#    macholib.dyld
#    macholib.mach_o
#    macholib.util
#    multiprocessing
#    multiprocessing.popen_fork
#    multiprocessing.popen_spawn_posix
#    multiprocessing.popen_spawn_win32
#    multiprocessing.spawn
#    nt
#    opcode
#    operator
#    os
#    pathlib
#    pkg_resources
#    pkgutil
#    platform
#    plistlib
#    pprint
#    py
#    py_compile
#    pyi_splash
#    pyimod00_crypto_key
#    pyimod03_importers
#    pywintypes
#    re
#    shutil
#    site
#    stat
#    struct
#    subprocess
#    sysconfig
#    tempfile
#    textwrap
#    traceback
#    types
#    typing
#    urllib
#    urllib.request
#    warnings
#    weakref
#    win32com
#    win32com.gen_py
#    win32ctypes.pywin32
#    xml
#    xml.dom
#    xml.dom.minidom
#    xml.etree
#    zipfile

# ERROR: pyinstaller-4.5.1-r0 do_package: QA Issue: File '/usr/lib/python3.9/site-packages/PyInstaller/bootloader/Linux-64bit-intel/run' from pyinstaller was already stripped, this will prevent future debugging! [already-stripped]
# ERROR: pyinstaller-4.5.1-r0 do_package: QA Issue: File '/usr/lib/python3.9/site-packages/PyInstaller/bootloader/Linux-64bit-intel/run_d' from pyinstaller was already stripped, this will prevent future debugging! [already-stripped]
INSANE_SKIP:${PN} += "already-stripped"

BBCLASSEXTEND = "native nativesdk"
