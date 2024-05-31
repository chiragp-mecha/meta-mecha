DESCRIPTION = "libncursesw6"
SUMMARY = "libncursesw.so.6.4"
HOMEPAGE = "https://github.com/Thomas-Tsai/partclone"
SECTION = "Image clone and flash"
LICENSE = "CLOSED"

SRC_URI = "http://ftp.debian.org/debian/pool/main/n/ncurses/libncursesw6_6.1+20181013-2+deb10u2_arm64.deb;protocol=https"
SRC_URI[sha256sum] = "da4dc6c68aecff023f614ce84355291486b72068e6e0bf7b27d16b78361b162b"


S = "${WORKDIR}"

DEPENDS = "libtinfo6"

do_install() {
    install -d ${D}${libdir}
    install ${S}/lib/aarch64-linux-gnu/* ${D}${libdir}
}

FILES:${PN} = "${libdir}"

INSANE_SKIP:${PN} += "already-stripped"
