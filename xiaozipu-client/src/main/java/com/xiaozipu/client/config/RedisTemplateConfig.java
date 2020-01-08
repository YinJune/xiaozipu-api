package com.xiaozipu.client.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @description:
 * @author: Yin JunJie
 * @date: 2019/12/23 20:39
 */
public class RedisTemplateConfig {

    private static Logger logger = LoggerFactory.getLogger(RedisTemplateConfig.class);

    /**
     * RedisTemplate配置
     *
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        // 设置hash key 和value序列化模式
        //使用StringRedisSerializer来序列化和反序列化redis的key值
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //使用GenericJackson2JsonRedisSerializer来序列化和反序列化redis的value值（默认使用JDK的序列化方式）
        GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        // 值采用json序列化
        redisTemplate.setValueSerializer(genericJackson2JsonRedisSerializer);
        redisTemplate.setHashValueSerializer(genericJackson2JsonRedisSerializer);

        if (redisConnectionFactory instanceof LettuceConnectionFactory) {
            logger.info("redisConnectionFactory is LettuceConnectionFactory");
            LettuceConnectionFactory lettuceConnectionFactory = (LettuceConnectionFactory) redisConnectionFactory;
            logger.info("redis configuration timeout:{}", lettuceConnectionFactory.getTimeout());
        } else {
            logger.info("redisConnectionFactory is not LettuceConnectionFactory");
        }
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }
}
