package com.kiseki.daemon.util;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

public class CalculateUtils {
/*
    @Resource
    private RedissonClient redissonClient;

    private static int len = 779;

    *//**
     * Redisson分布式锁的使用例子
     * @param x
     * @param lockName
     * @param expireTime
     * @return
     *//*
    public int add(int x, String lockName, long expireTime) {
        RLock rLock = redissonClient.getLock(lockName);
        try {
            boolean isLocked = rLock.tryLock(expireTime, TimeUnit.MILLISECONDS);
            if (isLocked) {
                // 若运行时检测到 x = 0,那么 jvm会自动抛出异常，(可以理解成由jvm自己负责 athrow 指令调用)
                x = 100 / x;
            }
        } catch (Exception e) {
            x = 100;
            rLock.unlock();
        }
        return x;
    }*/
}
