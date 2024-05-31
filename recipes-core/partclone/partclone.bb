DESCRIPTION = "Partclone"
SUMMARY = "partclone command for image flash"
HOMEPAGE = "https://github.com/Thomas-Tsai/partclone"
SECTION = "Image clone and flash"
LICENSE = "CLOSED"

#SRC_URI = "http://ftp.debian.org/debian/pool/main/p/partclone/partclone_0.3.13+dfsg-5_arm64.deb;protocol=https"
#SRC_URI[sha256sum] = "b2bcf3168252997d238225b68c5edb9de3272126604ab76d613b69b0751cf88a"

#SRC_URI = "http://ftp.debian.org/debian/pool/main/p/partclone/partclone_0.3.27+repack-2+b2_arm64.deb;protocol=https"
#SRC_URI[sha256sum] = "1b2b47091cbedbc4ae312dd444fe9cd5e62c6c889aa30273cb67c86e2e3bdd2d"

SRC_URI = "file://partclone_0.3.23+repack-1_arm64.deb"

S = "${WORKDIR}"

DEPENDS += "btrfs-tools e2fsprogs ncurses glibc ntfs3g libncursesw6 libtinfo6"
RDEPENDS:${PN} += "ncurses ncurses-libform openssl"

do_install() {
    install -d ${D}/${sbindir}
    install ${S}/usr/sbin/partclone.ext4 ${D}/${sbindir}
}

FILES:${PN} = "${sbindir}"

INSANE_SKIP:${PN} += "already-stripped"

#INSANE_SKIP_${PN} += "file-rdeps"
#do_package_qa[noexec] = "1"

# partclone.apfs
# partclone.btrfs
# partclone.chkimg
# partclone.dd
# partclone.exfat
# partclone.ext2
# partclone.ext3
# partclone.ext4
# partclone.ext4dev
# partclone.extfs
# partclone.f2fs
# partclone.fat
# partclone.fat12
# partclone.fat16
# partclone.fat32
# partclone.hfs+
# partclone.hfsp
# partclone.hfsplus
# partclone.imager
# partclone.info
# partclone.minix
# partclone.ntfs
# partclone.ntfsfixboot
# partclone.ntfsreloc
# partclone.reiser4
# partclone.restore
# partclone.vfat

# partclone.xfs
# partclone.nilfs2