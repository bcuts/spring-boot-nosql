package me.wonwoo.template;

import me.wonwoo.Person;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by wonwoolee on 2017. 8. 20..
 */
@Component
public class PersonTemplate {

  private final MongoTemplate mongoTemplate;

  public PersonTemplate(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  public void deleteAll() {
    mongoTemplate.dropCollection(Person.class);
  }

  public void save(Person person) {
    mongoTemplate.save(person);
  }

  public List<Person> findAll() {
    return mongoTemplate.findAll(Person.class);
  }
}
