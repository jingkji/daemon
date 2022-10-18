package com.kiseki.daemon.service.impl;

import com.kiseki.daemon.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {

    private RedisTemplate redisTemplate;

    @Override
    public Boolean tryLock(String key, String value, long timeout, TimeUnit unit) {
        return redisTemplate.opsForValue().setIfAbsent(key, value, timeout, unit);
    }

    @Override
    public void unlock(String lockName, String uuid) {
        if (uuid.equals(redisTemplate.opsForValue().get(lockName))) {
            redisTemplate.opsForValue().getAndDelete(lockName);
        }
    }

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
