PRODUCT_SOONG_NAMESPACES += \
    vendor/xiaomi/part

PART_PATH := vendor/xiaomi/part

PRODUCT_COPY_FILES += \
    $(PART_PATH)/vendor/lib/libDiracAPI_SHARED.so:$(TARGET_COPY_OUT_VENDOR)/lib/libDiracAPI_SHARED.so \
    $(PART_PATH)/vendor/lib/soundfx/libdirac.so:$(TARGET_COPY_OUT_VENDOR)/lib/soundfx/libdirac.so \
    $(PART_PATH)/vendor/etc/diracmobile.config:$(TARGET_COPY_OUT_VENDOR)/etc/diracmobile.config \
    $(PART_PATH)/vendor/etc/diracvdd.bin:$(TARGET_COPY_OUT_VENDOR)/etc/diracvdd.bin

# Sepolicy
SYSTEM_EXT_PRIVATE_SEPOLICY_DIRS += $(PART_PATH)/sepolicy/private
BOARD_VENDOR_SEPOLICY_DIRS += $(PART_PATH)/sepolicy/vendor

# XiaomiParts
PRODUCT_PACKAGES += \
    XiaomiParts \
    init.xiaomi_parts.rc

# Props ($PATH_PROP)
TARGET_PRODUCT_PROP += $(PART_PATH)/dirac.prop
