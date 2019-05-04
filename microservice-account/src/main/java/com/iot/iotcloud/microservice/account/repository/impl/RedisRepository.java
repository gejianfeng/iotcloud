package com.iot.iotcloud.microservice.account.repository.impl;

import com.iot.iotcloud.library.dal.repository.impl.RedisDbRepository;
import com.iot.iotcloud.microservice.account.repository.IRedisRepository;
import org.springframework.stereotype.Repository;

/**
 * Redis数据仓库实例实现
 * @author Ge Jian Feng
 * @version 1.0.0
 */
@Repository
public class RedisRepository extends RedisDbRepository implements IRedisRepository {
}
