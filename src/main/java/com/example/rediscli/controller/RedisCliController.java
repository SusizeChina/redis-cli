package com.example.rediscli.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class RedisCliController {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @GetMapping("/v1/set-value")
    public String setValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
        redisTemplate.expire(key, 30, TimeUnit.MILLISECONDS);
        return "OK";
    }

    @GetMapping("/v1/get-value")
    @Cacheable(cacheNames = "test", key = "#key")
    public String getValue(String key) {
        String test = "12344355";
        return test;
    }

    @GetMapping("/v1/del-value")
    public String delValue(String key) {
        redisTemplate.delete(key);
        return "OK";
    }

    @GetMapping("/v1/set-hash-value")
    public String setHashValue(String key, String filed, String value) {
        redisTemplate.opsForHash().put(key, filed, value);
        return "OK";
    }


    @GetMapping("/v1/get-hash-value")
    public String getHashValue(String key, String filed) {
        String o = (String) redisTemplate.opsForHash().get(key, filed);
        return o;
    }
}
