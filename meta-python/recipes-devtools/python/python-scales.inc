SUMMARY = "Metrics for Python"
DESCRIPTION = "Tracks server state and statistics, allowing you to see what \
your server is doing. It can also send metrics to Graphite for graphing or to \
a file for crash forensics."
SECTION = "devel/python"
LICENSE = "Apache-2.0"
# LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
SRCNAME = "scales"

SRC_URI[md5sum] = "c61167f2b5f506f0a34a7b8a295a9567"
SRC_URI[sha256sum] = "8b6930f7d4bf115192290b44c757af5e254e3fcfcb75ff9a51f5c96a404e2753"

inherit pypi
