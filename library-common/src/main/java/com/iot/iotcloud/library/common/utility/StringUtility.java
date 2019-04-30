package com.iot.iotcloud.library.common.utility;

/**
 * 字符串工具
 * @author Ge Jian Feng
 * @version 1.0.0
 */
public final class StringUtility {

    /**
     * 比对字符串是否相同
     * @param a 待比对字符串对象a
     * @param b 待比对字符串对象b
     * @return 比对结果
     */
    public static boolean isEqual(String a, String b) {
        return a != null ? a.equals(b) : b == null;
    }

    /**
     * 检查字符串对象是否为空对象或空字符串
     * @param str 待检查字符串
     * @return 检查结果
     */
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

}
