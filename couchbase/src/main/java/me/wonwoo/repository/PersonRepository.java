package me.wonwoo.repository;

import me.wonwoo.Person;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

/**
 * Created by wonwoolee on 2017. 8. 27..
 */
@ViewIndexed(designDoc = "person")
public interface PersonRepository extends CouchbaseRepository<Person, String> {
}
