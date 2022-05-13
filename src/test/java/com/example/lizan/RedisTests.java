package com.example.lizan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LocalEsApplication.class)
public class RedisTests {
    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void helloRedis() throws IOException {
        stringRedisTemplate.opsForValue().set("hello_redis_1","helloRedis");

    }


}
