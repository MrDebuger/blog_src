package com.redis.session.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author jianfeng[mailjianfeng@163.com]
 */
@Configuration
@EnableRedisHttpSession
public class RedisConfig {
}
