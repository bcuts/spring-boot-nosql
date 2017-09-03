package me.wonwoo.repository;

import me.wonwoo.Person;
import org.springframework.data.cassandra.repository.CassandraRepository;

/**
 * Created by wonwoolee on 2017. 8. 21..
 */
public interface PersonRepository extends CassandraRepository<Person> {

  Person findByName(String name);

}
