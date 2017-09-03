package me.wonwoo.repository;

import me.wonwoo.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by wonwoolee on 2017. 8. 20..
 */
public interface PersonRepository extends ElasticsearchRepository<Person, String> {

  Person findByName(String name);
}
