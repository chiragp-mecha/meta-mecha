DESCRIPTION = "ntfs3g"
SUMMARY = "libntfs-3g.so.883"
HOMEPAGE = "https://github.com/Thomas-Tsai/partclone"
SECTION = "Image clone and flash"
LICENSE = "CLOSED"

SRC_URI = "http://ftp.debian.org/debian/pool/main/n/ntfs-3g/libntfs-3g883_2017.3.23AR.3-3+deb10u2_arm64.deb;protocol=https"
SRC_URI[sha256sum] = "1af7dd7255b922fe52e4d0fd6498e5dac5836fffc087de9c98a3c25c8d4c7c4d"


S = "${WORKDIR}"

do_install() {
    install -d ${D}${libdir}
    install ${S}/lib/aarch64-linux-gnu/* ${D}${libdir}
}

FILES:${PN} = "${libdir}"

INSANE_SKIP:${PN} += "already-stripped"
