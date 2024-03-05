VERSION = "${DISTRO_VERSION}${DISTRO_MINOR_VERSION} LTS (${DISTRO_CODENAME})"
PRETTY_NAME = "${DISTRO_NAME} ${DISTRO_VERSION} LTS"
ID_LIKE="debian"
HOME_URL="https://mecha.so/"
SUPPORT_URL="https://forum.mecha.so"
BUG_REPORT_URL="https://forum.mecha.so"

do_install:append () {
    echo "HOME_URL=\"https://mecha.so/\"" >> ${D}${nonarch_libdir}/os-release
    echo "SUPPORT_URL=\"https://forum.mecha.so/\"" >> ${D}${nonarch_libdir}/os-release
    echo "BUG_REPORT_URL=\"https://forum.mecha.so/\"" >> ${D}${nonarch_libdir}/os-release
}