SUMMARY = "SSD1306"
#HOMEPAGE = "https://github.com/wheelin/ssd1306-rs"
HOMEPAGE = "https://github.com/squidpickles/nanohat-oled"
LICENSE="MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit cargo_bin

# Enable network for the compile task allowing cargo to download dependencies
do_compile[network] = "1"

SRC_URI = "git://github.com/squidpickles/nanohat-oled.git;protocol=https;branch=master"
SRCREV="c2b94220659e9a65cce62b9a2a0b63267405ead2"

S = "${WORKDIR}/git"

