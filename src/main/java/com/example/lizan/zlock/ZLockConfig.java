package com.example.lizan.zlock;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configurable
public class ZLockConfig implements ImportAware {
    /**
     * @return
     * @author zhaocheng
     */
    @Bean
    public DistributedLockableAspect distributedLockableAspect() {
        return new DistributedLockableAspect();
    }

    /**
     * @return
     * @author zhaocheng
     */
    @Bean
    public ZLockClient redisLockClient(StringRedisTemplate redisTemplate) {
        return new ZLockClient(redisTemplate);
    }

//    @Bean
//    public RedisSemaphoreSync redisSemaphoreSync() {
//        return new RedisSemaphoreSync();
//    }

    /**
     * @param factory
     * @return
     * @author zhaocheng
     */
    @Bean
    @ConditionalOnMissingBean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory factory) {

        StringRedisSerializer keySerializer = new StringRedisSerializer();
        RedisSerializer<?> serializer = new StringRedisSerializer();
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(factory);
        template.setKeySerializer(keySerializer);
        template.setHashKeySerializer(keySerializer);
        template.setValueSerializer(serializer);
        template.setHashValueSerializer(serializer);
        template.afterPropertiesSet();

        return template;

    }

    @Override
    public void setImportMetadata(AnnotationMetadata importMetadata) {

    }
}
