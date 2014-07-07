SUMMARY = "strictures - turn on strict and make all warnings fatal"
DESCRIPTION = "I've been writing the equivalent of this module at the top \
of my code for about a year now. I figured it was time to make it shorter. \
\
Things like the importer in \"use Moose\" don't help me because they turn \
warnings on but don't make them fatal -- which from my point of view is \
useless because I want an exception to tell me my code isn't warnings-clean. \
\
Any time I see a warning from my code, that indicates a mistake. \
\
Any time my code encounters a mistake, I want a crash -- not spew to STDERR \
and then unknown (and probably undesired) subsequent behaviour. \
\
I also want to ensure that obvious coding mistakes, like indirect object \
syntax (and not so obvious mistakes that cause things to accidentally compile \
as such) get caught, but not at the cost of an XS dependency and not at the \
cost of blowing things up on another machine. \
\
Therefore, \"strictures\" turns on additional checking, but only when it \
thinks it's running in a test file in a VCS checkout -- although if this \
causes undesired behaviour this can be overridden by setting the \
PERL_STRICTURES_EXTRA environment variable."

SECTION = "libs"

HOMEPAGE = "https://metacpan.org/pod/strictures"

LICENSE = "Artistic-1.0 | GPL-1.0+"
LIC_FILES_CHKSUM = "file://README;beginline=174;endline=180;md5=ccaeb4f589794955aa56c68aea6d38c1"

SRC_URI = "${CPAN_MIRROR}/authors/id/H/HA/HAARG/strictures-${PV}.tar.gz"
SRC_URI[md5sum] = "1da9241286818e8d374fb9849d17a13d"
SRC_URI[sha256sum] = "bbf066cfb37d3ae4b23d1fcf5c7aea276ae3b3b43c5fc7472e1d1880cc063879"

S = "${WORKDIR}/strictures-${PV}"

inherit cpan

RDEPENDS_${PN} = " perl-module-test-more"

BBCLASSEXTEND = "native"
