package com.iot.iotcloud.library.common.utility;

import org.slf4j.Logger;

/**
 * 日志工具
 * @author Ge Jian Feng
 * @version 1.0.0
 */
public final class LogUtility {

    /**
     * 错误日志
     * @param logger 日志对象
     * @param errorMsg 错误消息
     */
    public static void logError(Logger logger, String errorMsg) {
        if (logger == null || StringUtility.isNullOrEmpty(errorMsg)) {
            return;
        }

        logger.error(errorMsg);
    }

    /**
     * 错误日志
     * @param logger 日志对象
     * @param errorMsg 错误消息
     * @param ex 异常对象
     */
    public static void logError(Logger logger, String errorMsg, Exception ex) {
        if (logger == null || StringUtility.isNullOrEmpty(errorMsg)) {
            return;
        }

        logger.error(errorMsg, ex);
    }

    /**
     * 错误日志
     * @param logger 日志对象
     * @param errorMsg 错误消息
     * @param object 错误日志包含对象
     */
    public static void logError(Logger logger, String errorMsg, Object object) {
        if (logger == null || StringUtility.isNullOrEmpty(errorMsg)) {
            return;
        }

        if (object != null) {
            String _objStr = JsonUtility.toJson(object);

            if (StringUtility.isNullOrEmpty(_objStr)) {
                logger.error(errorMsg);
            }
            else {
                logger.error(errorMsg + " | " + _objStr);
            }
        }
        else {
            logger.error(errorMsg);
        }
    }

    /**
     * 错误日志
     * @param logger 日志对象
     * @param errorMsg 错误消息
     * @param object 错误日志包含对象
     * @param ex 异常对象
     */
    public static void logError(Logger logger, String errorMsg, Object object, Exception ex) {
        if (logger == null || StringUtility.isNullOrEmpty(errorMsg)) {
            return;
        }

        if (object != null) {
            String _objStr = JsonUtility.toJson(object);

            if (StringUtility.isNullOrEmpty(_objStr)) {
                logger.error(errorMsg, ex);
            }
            else {
                logger.error(errorMsg + " | " + _objStr, ex);
            }
        }
        else {
            logger.error(errorMsg, ex);
        }
    }
}
