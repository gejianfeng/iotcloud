package com.iot.iotcloud.library.common.utility;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Json工具
 * @author Ge Jian Feng
 * @version 1.0.0
 */
public final class JsonUtility {

    /**
     * 转换对象
     */
    public static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 将json字符串转换为对象
     * @param jsonStr json字符串
     * @param classInfo 目标对象信息
     * @param <T> 目标对象类型
     * @return 转换后对象
     */
    public static <T> T readValue(String jsonStr, Class<T> classInfo) {
        T _ret = null;

        try {
            _ret = objectMapper.readValue(jsonStr, classInfo);
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        return _ret;
    }

    /**
     * 将json字符串转换为对象
     * @param jsonStr json字符串
     * @param typeReferenceInfo 目标对象引用信息
     * @param <T> 目标对象引用类型
     * @return 转换后对象
     */
    public static <T> T readValue(String jsonStr, TypeReference<T> typeReferenceInfo) {
        T _ret = null;

        try {
            _ret = objectMapper.readValue(jsonStr, typeReferenceInfo);
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        return _ret;
    }

    /**
     * 将对象转换为json字符串
     * @param object 待转换对象
     * @return json字符串
     */
    public static String toJson(Object object) {
        String _ret = null;

        try {
            _ret = objectMapper.writeValueAsString(object);
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        return _ret;
    }
}
