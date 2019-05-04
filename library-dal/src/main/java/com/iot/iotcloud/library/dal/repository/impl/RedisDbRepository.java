package com.iot.iotcloud.library.dal.repository.impl;

import com.iot.iotcloud.library.dal.repository.IRedisDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * Redis数据仓库实现
 * @author Ge Jian Feng
 * @version 1.0.0
 */
public abstract class RedisDbRepository extends BaseRepository implements IRedisDbRepository {

    /**
     * Redis句柄
     */
    @Autowired
    protected RedisTemplate<String, Object> m_redisTemplate;

    @Override
    public boolean expire(String key, long timeout, TimeUnit timeUnit) {
        if (key == null || key.isEmpty()) {
            return false;
        }

        if (timeout < 0) {
            return false;
        }

        return m_redisTemplate.expire(key, timeout, timeUnit);
    }

    @Override
    public long getExpire(String key) {
        if (key == null || key.isEmpty()) {
            return 0;
        }

        if (!hasKey(key)) {
            return 0;
        }

        return m_redisTemplate.getExpire(key);
    }

    @Override
    public boolean hasKey(String key) {
        if (key == null || key.isEmpty()) {
            return false;
        }

        return m_redisTemplate.hasKey(key);
    }

    @Override
    public boolean delete(String key) {
        if (key == null || key.isEmpty()) {
            return false;
        }

        if (!hasKey(key)) {
            return false;
        }

        return m_redisTemplate.delete(key);
    }

    @Override
    public Object get(String key) {
        if (key == null || key.isEmpty()) {
            return false;
        }
        else {
            return m_redisTemplate.opsForValue().get(key);
        }
    }

    @Override
    public String getAsString(String key) {
        Object _object = get(key);
        return _object == null ? null : _object.toString();
    }

    @Override
    public void set(String key, Object value, long timeout, TimeUnit timeUnit) {
        if (key == null || key.isEmpty()) {
            throw new RuntimeException("待设置缓存键值不能位空");
        }

        if (timeout > 0) {
            m_redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
        }
        else {
            m_redisTemplate.opsForValue().set(key, value);
        }
    }

    @Override
    public boolean setNx(String key, Object value, long timeout, TimeUnit timeUnit) {
        if (key == null || key.isEmpty()) {
            throw new RuntimeException("待设置缓存键值不能位空");
        }

        return m_redisTemplate.opsForValue().setIfAbsent(key, value, timeout, timeUnit);
    }

}
