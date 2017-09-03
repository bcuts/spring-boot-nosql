package me.wonwoo.template;

import com.couchbase.client.java.view.ViewQuery;
import com.couchbase.client.java.view.ViewResult;
import com.couchbase.client.java.view.ViewRow;
import me.wonwoo.Person;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by wonwoolee on 2017. 8. 27..
 */
@Component
public class PersonTemplate {

  private final CouchbaseTemplate couchbaseTemplate;

  public PersonTemplate(CouchbaseTemplate couchbaseTemplate) {
    this.couchbaseTemplate = couchbaseTemplate;
  }

  public void deleteAll() {
    ViewQuery query = ViewQuery.from("person", "all");
    query.reduce(false);
    query.stale(couchbaseTemplate.getDefaultConsistency().viewConsistency());

    ViewResult response = couchbaseTemplate.queryView(query);
    for (ViewRow row : response) {
      try {
        couchbaseTemplate.remove(row.id());
      } catch (DataRetrievalFailureException e) {
        //ignore
      }
    }
  }

  public void save(Person person) {
    couchbaseTemplate.save(person);
  }

  public List<Person> findAll() {
    ViewQuery query = ViewQuery.from("person", "all");
    query.reduce(false);
    query.stale(couchbaseTemplate.getDefaultConsistency().viewConsistency());
    return couchbaseTemplate.findByView(query, Person.class);
  }

}
