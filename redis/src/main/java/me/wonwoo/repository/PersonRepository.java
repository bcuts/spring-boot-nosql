package me.wonwoo.repository;

import me.wonwoo.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by wonwoolee on 2017. 8. 20..
 */
public interface PersonRepository extends CrudRepository<Person, String> {
}
