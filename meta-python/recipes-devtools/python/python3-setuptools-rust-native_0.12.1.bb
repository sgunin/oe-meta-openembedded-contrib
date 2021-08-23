SUMMARY = "Setuptools Rust extension plugin"
HOMEPAGE = "https://github.com/PyO3/setuptools-rust"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=011cd92e702dd9e6b1a26157b6fd53f5"

SRC_URI[sha256sum] = "647009e924f0ae439c7f3e0141a184a69ad247ecb9044c511dabde232d3d570e"
SRC_URI[sha384sum] = "2162e5e347ded97c849466da40fb17907648e848ee663c09caad316349caca9648dc73161d747ac91535a4120d8706b5"
SRC_URI[sha512sum] = "02dc2e2c91533ae847cfe7be0e7b0816fb376405f979c9767ba415c0223aa57429f1c038eb6c06ac9ec3950738b55026fbc6d4c8a8d938cf58a975d40d84cdb8"

inherit cargo pypi setuptools3 native

DEPENDS += "python3-setuptools-scm-native python3-wheel-native"

RDEPENDS:${PN}:class-native += " \
    python3-semantic-version-native \
    python3-setuptools-native \
    python3-setuptools-scm-native \
    python3-toml-native \
    python3-wheel-native \
"
