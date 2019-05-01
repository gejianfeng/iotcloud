package com.iot.iotcloud.library.model.dto;

/**
 * 通用响应DTO基类
 * @author Ge Jian Feng
 * @version 1.0.0
 */
public class CommonResponseDTO<T> extends RequestDTO {

    /**
     * 操作结果
     */
    private String result;

    /**
     * 响应返回数据
     */
    private T data;

    /**
     * 获取操作结果
     * @return 操作结果
     */
    public String getResult() {
        return result;
    }

    /**
     * 设置操作结果
     * @param result 待设置操作结果
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * 获取返回数据
     * @return 返回数据
     */
    public T getData() {
        return data;
    }

    /**
     * 设置返回数据
     * @param data 待返回数据
     */
    public void setData(T data) {
        this.data = data;
    }
}
