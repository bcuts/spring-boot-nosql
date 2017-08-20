package me.wonwoo.template;

import me.wonwoo.Person;
import org.neo4j.ogm.session.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * Created by wonwoolee on 2017. 8. 20..
 */
@Component
@Transactional
public class PersonTemplate {

  private final Session session;

  public PersonTemplate(Session session) {
    this.session = session;
  }

  public void deleteAll() {
    session.deleteAll(Person.class);
  }

  public void save(Person person) {
    session.save(person);
  }

  public Collection<Person> findAll() {
    return session.loadAll(Person.class);
  }
}
