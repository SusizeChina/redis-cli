package com.example.rediscli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

import javax.xml.ws.BindingType;

@SpringBootApplication
@EnableCaching
public class RedisCliApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisCliApplication.class, args);
    }

}
