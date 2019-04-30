package com.iot.iotcloud.library.common.utility;

import java.util.UUID;

/**
 * UUID工具类
 * @author Ge Jian Feng
 * @version 1.0.0
 */
public final class UuidUtility {

    /**
     * 生成UUID
     * @return 系统生成UUID
     */
    public static UUID generateUuid() {
        return UUID.randomUUID();
    }

    /**
     * 生成UUID字符串
     * @return UUID字符串
     */
    public static String generateUUIDString() {
        String _uuidString = generateUuid().toString();
        return _uuidString.replace("-", "");
    }

}
