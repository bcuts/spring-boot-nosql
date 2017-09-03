package me.wonwoo.repository;

import me.wonwoo.Person;
import org.springframework.data.solr.repository.SolrCrudRepository;

/**
 * Created by wonwoolee on 2017. 8. 26..
 */
public interface PersonRepository extends SolrCrudRepository<Person, String> {

  Person findByName(String name);
}
