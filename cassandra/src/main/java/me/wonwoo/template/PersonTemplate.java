package me.wonwoo.template;

import me.wonwoo.Person;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by wonwoolee on 2017. 8. 21..
 */
@Component
public class PersonTemplate {

  private final CassandraTemplate cassandraTemplate;

  public PersonTemplate(CassandraTemplate cassandraTemplate) {
    this.cassandraTemplate = cassandraTemplate;
  }

  public void deleteAll() {
    cassandraTemplate.deleteAll(Person.class);
  }

  public void save(Person person) {
    cassandraTemplate.insert(person);
  }

  public List<Person> findAll() {
    return cassandraTemplate.selectAll(Person.class);
  }
}
