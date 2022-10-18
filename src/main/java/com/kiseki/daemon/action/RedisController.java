package com.kiseki.daemon.action;

import com.kiseki.daemon.service.RedisService;
import com.kiseki.daemon.util.RedisUtils;
import io.lettuce.core.RedisException;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Optionals;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private RedisService redisService;

    @PostMapping("setValue")
    public String setValue(@RequestBody Map<String, Object> params) {
        params.forEach((k, v) -> {
            redisUtils.set(k, v);
        });
        return "请求成功！";
    }


    @GetMapping("getValue")
    public String getValue(@Param("key") String key) {
        if(!Optional.ofNullable(redisUtils.get(key)).isPresent()) {
            throw new RedisException("找不到对应key的值");
        }
        return redisUtils.get(key).toString();
    }


    @GetMapping("testLock")
    public String testLock(@Param("key") String key) {

        return "1";
    }
}
