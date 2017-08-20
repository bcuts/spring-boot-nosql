package me.wonwoo.repository;

import me.wonwoo.Person;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by wonwoolee on 2017. 8. 20..
 */
public interface PersonRepository extends GraphRepository<Person> {

}
