package com.example.lizan;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.Redisson;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LocalEsApplication.class)
public class RedisTests {
    @Resource
    StringRedisTemplate stringRedisTemplate;
    static RedissonClient redissonClient = null;
    static RBloomFilter rBloomFilter = null;
    private static final double fpp = 0.03;

    private static final String hello_set = "hello_set_1";
    private static final String hello_zset = "hello_zset_1";
    @Test
    public void helloRedis() throws IOException {
        stringRedisTemplate.opsForValue().set("hello_redis_1", "helloRedis");

    }

    @Test
    public void helloRedis2() throws IOException {

      /*  String s = stringRedisTemplate.opsForValue().get("hello_redis_1");
        System.out.println(s);*/
//        stringRedisTemplate.expire("hello_redis_1",2, TimeUnit.SECONDS);
        Long expire = stringRedisTemplate.getExpire("hello_redis_1");
        System.out.println(expire);

    }

    @Test
    public void helloSet() throws IOException {

//        stringRedisTemplate.opsForSet().add(hello_set, "1", "2", "3", "4", "a", "b");
        Boolean b = stringRedisTemplate.opsForSet().isMember(hello_set, "2");
        System.out.println(b);

        System.out.println(stringRedisTemplate.opsForSet().members(hello_set));
        System.out.println(stringRedisTemplate.opsForSet().size(hello_set));
        System.out.println(stringRedisTemplate.opsForSet().remove(hello_set, "2"));
    }

    @Test
    public void helloYS() throws IOException {

        System.out.println(2 & 3);
    }

    @Test
    public void helloHashCode() throws IOException {

        Set<Integer> hashCodeSet = new HashSet<>();

        for (int i = 0; i < 200000; i++) {
            int hashCode = new Object().hashCode();
            if (hashCodeSet.contains(hashCode)) {
                System.out.println("??????????????????hashcode: " + hashCode + "\t ?????????" + i);
                break;
            }
            hashCodeSet.add(hashCode);
        }

        System.out.println("Aa".hashCode());
        System.out.println("BB".hashCode());
        System.out.println("??????".hashCode());
        System.out.println("??????".hashCode());
    }

    @Test
    public void helloZSet() throws IOException {
//        stringRedisTemplate.opsForZSet().add(hello_zset,"lisi",10);
//        stringRedisTemplate.opsForZSet().add(hello_zset,"lisi2",30);
//        stringRedisTemplate.opsForZSet().add(hello_zset,"lisi3",30);
//        stringRedisTemplate.opsForZSet().add(hello_zset,"lisi4",60);
//        stringRedisTemplate.opsForZSet().add(hello_zset,"lisi5",50);

        System.out.println(stringRedisTemplate.opsForZSet().range(hello_zset, 0, 10));
        System.out.println(stringRedisTemplate.opsForZSet().rangeWithScores(hello_zset, 0, 10));
        System.out.println(stringRedisTemplate.opsForZSet().rangeByScore(hello_zset, 0, 10));
        System.out.println(stringRedisTemplate.opsForZSet().rank(hello_zset, "lisi2"));
        System.out.println(stringRedisTemplate.opsForZSet().zCard(hello_zset));
    }

    /**
     * ???????????????
     * @throws IOException
     */
    @Test
    public void helloBloomFilter() throws IOException {
        BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(), 100);
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));
        filter.put(1);
        filter.put(2);
        System.out.println("---------------------");
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));


    }
    private static int size = 100 * 10000;
    @Test
    public void helloBloomFilter2() throws IOException {
        BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(), size,0.00001);
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));
        filter.put(1);
        filter.put(2);
        System.out.println("---------------------");
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));


    }


    static
    {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.111.147:6379").setDatabase(0);
        //??????redisson
        redissonClient = Redisson.create(config);
        //??????redisson??????rBloomFilter
        rBloomFilter = redissonClient.getBloomFilter("phoneListBloomFilter",new StringCodec());

        rBloomFilter.tryInit(size,fpp);

        // 1??????  ??????????????????+redis???
        rBloomFilter.add("10086");
        redissonClient.getBucket("10086",new StringCodec()).set("chinamobile10086");

        // 2??????  ??????????????????+redis???
        //rBloomFilter.add("10087");

        //3 ?????? ????????????

    }


    @Test
    public void helloRedisBloomFilter2() throws IOException {




    }

}
