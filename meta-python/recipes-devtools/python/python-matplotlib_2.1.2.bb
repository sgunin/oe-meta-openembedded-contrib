require python-matplotlib.inc
inherit setuptools python-dir

RDEPENDS_${PN} += "python-backports-functools-lru-cache python-functools32"
