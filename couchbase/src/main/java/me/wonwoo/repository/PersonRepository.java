package me.wonwoo.repository;

import me.wonwoo.Person;
import org.springframework.data.couchbase.core.query.View;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

import java.util.List;

/**
 * Created by wonwoolee on 2017. 8. 27..
 */
@ViewIndexed(designDoc = "person")
public interface PersonRepository extends CouchbaseRepository<Person, String> {

  @View(viewName = "byName")
  List<Person> findByName(String name);
}
