package me.wonwoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * Created by wonwoolee on 2017. 8. 20..
 */
@SpringBootApplication
public class RedisApplication {
  public static void main(String[] args) {
    SpringApplication.run(RedisApplication.class, args);
  }

  @Bean
  public RedisTemplate<String, Person> personRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
    RedisTemplate<String,Person> template = new RedisTemplate<>();
    template.setValueSerializer(new Jackson2JsonRedisSerializer<>(Person.class));
    template.setConnectionFactory(redisConnectionFactory);
    return template;
  }
}
