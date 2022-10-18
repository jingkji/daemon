package com.kiseki.daemon.service;

import java.util.concurrent.TimeUnit;

public interface RedisService {

    /**
     * 加锁
     * @param key 键
     * @param value 值
     * @param timeout 时间
     * @param unit 时间单位
     * @return 是否加锁成功
     */
    Boolean tryLock(String key, String value, long timeout, TimeUnit unit);

    /**
     * 解锁
     * @param lockName 锁名
     * @param uuid uuid
     */
    void unlock(String lockName, String uuid);
}
