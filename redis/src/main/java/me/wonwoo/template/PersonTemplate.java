package me.wonwoo.template;

import me.wonwoo.Person;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by wonwoolee on 2017. 8. 20..
 */
@Component
public class PersonTemplate {

  private final RedisTemplate<String,Person> personRedisTemplate;

  public PersonTemplate(RedisTemplate<String, Person> personRedisTemplate) {
    this.personRedisTemplate = personRedisTemplate;
  }

  public void deleteAll() {
    personRedisTemplate.delete("persons");
  }

  public void save(Person person) {
    personRedisTemplate.opsForList().leftPush("persons", person);
  }

  public List<Person> findAll() {
    return personRedisTemplate.opsForList().range("persons", 0, -1);
  }
}
