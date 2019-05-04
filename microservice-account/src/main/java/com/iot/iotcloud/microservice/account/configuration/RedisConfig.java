package com.iot.iotcloud.microservice.account.configuration;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Redis配置
 * @author Ge Jian Feng
 * @version 1.0.0
 */
@Configuration
public class RedisConfig {

    /**
     * 构建自定义RedisTemplate
     * @param factory Redis连接工厂
     * @return 自定义RedisTemplate
     */
    @Bean
    public RedisTemplate<String, Object> customRedisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> _template = new RedisTemplate<>();
        _template.setConnectionFactory(factory);

        Jackson2JsonRedisSerializer _jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper _objectMapper = new ObjectMapper();
        _objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        _objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        _jackson2JsonRedisSerializer.setObjectMapper(_objectMapper);

        StringRedisSerializer _stringRedisSerializer = new StringRedisSerializer();
        _template.setKeySerializer(_stringRedisSerializer);
        _template.setHashKeySerializer(_stringRedisSerializer);
        _template.setValueSerializer(_jackson2JsonRedisSerializer);
        _template.setHashValueSerializer(_jackson2JsonRedisSerializer);

        _template.afterPropertiesSet();

        return _template;
    }
}
