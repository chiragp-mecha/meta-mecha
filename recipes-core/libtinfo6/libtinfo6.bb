DESCRIPTION = "libtinfo6"
SUMMARY = "libtinfo.so.6.1"
HOMEPAGE = "https://github.com/Thomas-Tsai/partclone"
SECTION = "Image clone and flash"
LICENSE = "CLOSED"

SRC_URI = "http://ftp.debian.org/debian/pool/main/n/ncurses/libtinfo6_6.1+20181013-2+deb10u2_arm64.deb;protocol=https"
SRC_URI[sha256sum] = "1b0533fcee638b5c76a07fb6ce3a64e6cb67d5e81574d6541486c0b2130430d5"


S = "${WORKDIR}"

do_install() {
    install -d ${D}${libdir}
    install ${S}/usr/lib/aarch64-linux-gnu/* ${D}${libdir}
    
    install -d ${D}/lib
    install ${S}/lib/aarch64-linux-gnu/* ${D}/lib
}

FILES:${PN} = "${libdir}"
FILES:${PN} += "/lib/*"

INSANE_SKIP:${PN} += "already-stripped"



