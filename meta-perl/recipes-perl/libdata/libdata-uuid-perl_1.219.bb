SUMMARY = "Data::UUID - Globally\/Universally Unique Identifiers"
DESCRIPTION = "\
This module provides a framework for generating v3 UUIDs (Universally Unique\
Identifiers, also known as GUIDs (Globally Unique Identifiers). A UUID is 128\
bits long, and is guaranteed to be different from all other UUIDs/GUIDs\
generated until 3400 CE.\
\
UUIDs were originally used in the Network Computing System (NCS) and later in\
the Open Software Foundation's (OSF) Distributed Computing Environment.\
Currently many different technologies rely on UUIDs to provide unique identity\
for various software components. Microsoft COM/DCOM for instance, uses GUIDs\
very extensively to uniquely identify classes, applications and components\
across network-connected systems.\
\
The algorithm for UUID generation, used by this extension, is described in the\
Internet Draft "UUIDs and GUIDs" by Paul J. Leach and Rich Salz.  (See RFC\
4122.)  It provides reasonably efficient and reliable framework for generating\
UUIDs and supports fairly high allocation rates -- 10 million per second per\
machine -- and therefore is suitable for identifying both extremely short-lived\
and very persistent objects on a given system as well as across the network.\
\
This modules provides several methods to create a UUID.  In all methods,\
\"namespace\" is a UUID and \"name\" is a free form string."

SECTION = "libs"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f2d75ccbaa89acc4b84a776b80f2833b"

SRC_URI = "${CPAN_MIRROR}/authors/id/R/RJ/RJBS/Data-UUID-${PV}.tar.gz"
SRC_URI[md5sum] = "8ca1f802b40d9b563f4de26968677097"
SRC_URI[sha256sum] = "c736d39a6fabf163423b85d94c62cbba6f57ca2f3115e21a0d0c91c23836da28"

S = "${WORKDIR}/Data-UUID-${PV}"

inherit cpan

RDEPENDS_${PN} = " perl-module-digest-md5"

BBCLASSEXTENDS = "native"
