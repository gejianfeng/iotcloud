package com.iot.iotcloud.library.dal.repository;

import java.util.concurrent.TimeUnit;

/**
 * Redis数据仓库接口
 * @author Ge Jian Feng
 * @version 1.0.0
 */
public interface IRedisDbRepository extends IBaseRepository {

    /**
     * 指定缓存失效时间
     * @param key 待修改缓存失效时间缓存键值
     * @param timeout 待修改缓存失效时间
     * @param timeUnit 失效时间单位
     * @return 操作成功失败结果
     */
    boolean expire(String key, long timeout, TimeUnit timeUnit);

    /**
     * 获取指定键值失效时间
     * @param key 待查询失效时间缓存键值
     * @return 缓存失效时间
     */
    long getExpire(String key);

    /**
     * 检测缓存是否存在
     * @param key 待检测缓存键值
     * @return 检测结果
     */
    boolean hasKey(String key);

    /**
     * 删除缓存
     * @param key 待删除缓存键值
     * @return 删除结果
     */
    boolean delete(String key);

    /**
     * 获取缓存对象
     * @param key 待获取缓存对象键值
     * @return 缓存对象
     */
    Object get(String key);

    /**
     * 以字符串形式获取缓存对象
     * @param key 待获取缓存对象键值
     * @return 缓存对象字符串
     */
    String getAsString(String key);

    /**
     * 设置缓存对象
     * @param key 待设置缓存键值
     * @param value 待设置缓存对象
     * @param timeout 待设置缓存超时时间
     * @param timeUnit 待设置缓存超时时间单位
     */
    void set(String key, Object value, long timeout, TimeUnit timeUnit);

    /**
     * 设置缓存锁
     * @param key 待设置缓存键值
     * @param value 待设置缓存对象
     * @param timeout 待设置缓存超时时间
     * @param timeUnit 待设置缓存超时时间单位
     */
    boolean setNx(String key, Object value, long timeout, TimeUnit timeUnit);

}
