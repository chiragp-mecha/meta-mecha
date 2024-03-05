# Copyright 2018-2021 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "This is the basic core image with minimal tests"

inherit core-image

IMAGE_FEATURES += " \
    tools-profile \
    tools-sdk \
    splash \
    nfs-server \
    tools-debug \
    ssh-server-openssh \
    hwcodecs \
    weston \
"

#   ssh-server-dropbear has been replaced with ssh-server-openssh in IMAGE_FEATURES

SDKIMAGE_FEATURES:append = " \
    staticdev-pkgs \
"

IMAGE_INSTALL += " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', 'weston-xwayland xterm', '', d)} \
    imx-test \
    firmwared \
    packagegroup-imx-core-tools \
    packagegroup-imx-security \
    curl \
    ${CLINFO} \
    ${DOCKER} \
"

CLINFO              ?= ""
CLINFO:imxgpu        = "clinfo"
CLINFO:mx8mm-nxp-bsp = ""
CLINFO:mx7-nxp-bsp   = ""

DOCKER            ?= ""
DOCKER:mx8-nxp-bsp = "docker"

export IMAGE_BASENAME = "mecha-image-full"

#-----------------------------------------------------------------------------------

# IMAGE_FSTYPES="wic.bmap wic.zst tar.zst tar.bz2 tar.gz"
IMAGE_FSTYPES = "wic.zst tar.zst"

CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-base \
    packagegroup-core-full-cmdline \
    packagegroup-tools-bluetooth \
    packagegroup-fsl-tools-audio \
    packagegroup-fsl-pulseaudio \
    packagegroup-fsl-tools-testapps \
    packagegroup-fsl-tools-benchmark \
    packagegroup-imx-isp \
    packagegroup-imx-security \
    packagegroup-core-weston \
    packagegroup-core-ssh-openssh \
    ${@bb.utils.contains("DISTRO_FEATURES", "pam", "passwdqc", "", d)} \
"

# Enable package-management
EXTRA_IMAGE_FEATURES += "package-management"
PACKAGE_FEED_URIS = "https://mecha-org.com/packagerepos/release \
                     https://mecha-org.com/packagerepos/updates"
PACKAGE_FEED_BASE_PATHS = "deb deb-dev"
#PACKAGE_FEED_ARCHS = "all core2-64"

IMAGE_INSTALL:append = " networkmanager networkmanager-nmtui networkmanager-nmcli"
IMAGE_INSTALL:append = " nftables nftables-python"
IMAGE_INSTALL:append = " firewalld"
IMAGE_INSTALL:append = " openssh openssh-sshd"
#IMAGE_INSTALL:append = " connman connman-client" 
IMAGE_INSTALL:append = " libgpiod libgpiod-tools"

# GNU Privacy Guard - encryption and signing tools
IMAGE_INSTALL:append = " gnupg"

IMAGE_INSTALL:append = " ntp"
NTP_SERVERS = "time.google.com time1.google.com time.cloudflare.com"
TIMEZONE = "Asia/Kolkata"

IMAGE_INSTALL:append = " mesa mesa-demos"     
IMAGE_INSTALL:append = " bluez5"     
IMAGE_INSTALL:append = " dpkg"
IMAGE_INSTALL:append = " git"  
IMAGE_INSTALL:append = " zlib"
IMAGE_INSTALL:append = " easysplash easysplash-bootanimation-mecha"     

# poky/meta/recipes-graphics/xorg-app/
IMAGE_INSTALL:append = " xhost xauth sysbench htop"

IMAGE_INSTALL:append = " sway-1.9 swayidle swaylock sway-login-configs libpam-pwdfile"

# to,ezpme data
IMAGE_INSTALL:append = " tzdata"

# Onscreen keyboard
# IMAGE_INSTALL:append = " wvkbd"
# IMAGE_INSTALL:append = " squeekboard"

                    
IMAGE_INSTALL:append = " polkit-gnome"