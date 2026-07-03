package com.example.backend.common.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import tools.jackson.databind.ObjectMapper;

@Configuration(proxyBeanMethods = false)
@RequiredArgsConstructor
public class RedisConfig {

    private final ObjectMapper objectMapper;

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        StringRedisSerializer keySerializer = new StringRedisSerializer();
        Jackson3JsonRedisSerializer valueSerializer = new Jackson3JsonRedisSerializer(objectMapper);

        template.setKeySerializer(keySerializer);
        template.setHashKeySerializer(keySerializer);
        template.setValueSerializer(valueSerializer);
        template.setHashValueSerializer(valueSerializer);

        template.afterPropertiesSet();
        return template;
    }

    /**
     * Minimal Jackson 3 (tools.jackson) JSON serializer for Redis values.
     * Spring Data Redis 4 ships only Jackson 2-style serializers, so we wrap
     * the Jackson 3 {@link ObjectMapper} with a simple byte[] adapter.
     * Use simple Map/List/value types only; add default typing if polymorphic
     * round-trip is required.
     */
    static class Jackson3JsonRedisSerializer implements RedisSerializer<Object> {

        private final ObjectMapper mapper;

        Jackson3JsonRedisSerializer(ObjectMapper mapper) {
            this.mapper = mapper;
        }

        @Override
        public byte[] serialize(Object source) {
            try {
                return mapper.writeValueAsBytes(source);
            } catch (Exception e) {
                throw new SerializationException("Jackson3 serialize error", e);
            }
        }

        @Override
        public Object deserialize(byte[] bytes) {
            if (bytes == null || bytes.length == 0) {
                return null;
            }
            try {
                return mapper.readValue(bytes, Object.class);
            } catch (Exception e) {
                throw new SerializationException("Jackson3 deserialize error", e);
            }
        }
    }
}
