# Copyright (C) 2014 O.S. Systems Software LTDA.

DESCRIPTION = "Small image to be used with Manufacturing Tool \
(mfg-tool) in a production environment."

LICENSE = "MIT"

inherit mfgtool-initramfs-image

# meta-imx/meta-sdk/recipes-fsl/images also contains bbappend which contains:
#---------------------------------------------------#
# Replace linux-mfgtool with virtual/kernel
DEPENDS:remove = "linux-mfgtool"
DEPENDS:append = " virtual/kernel"
#---------------------------------------------------#

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

RDEPENDS:${PN} += "ncurses ncurses-libform libcrypto openssl"
# dosfstools : for mkfs commands
IMAGE_INSTALL:append = " e2fsprogs-resize2fs parted dosfstools partclone openssl"
#DEPENDS = " openssl"

install_uuu_script_initramfs() {
	cp -r ${THISDIR}/files/uuu_wic_ramfs.auto  ${DEPLOY_DIR_IMAGE}
}

ROOTFS_POSTPROCESS_COMMAND += "install_uuu_script_initramfs;"

IMAGE_FSTYPES = "cpio.gz.u-boot"