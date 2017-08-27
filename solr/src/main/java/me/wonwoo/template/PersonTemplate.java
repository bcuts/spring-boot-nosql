package me.wonwoo.template;

import me.wonwoo.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.*;
import org.springframework.stereotype.Component;

/**
 * Created by wonwoolee on 2017. 8. 26..
 */
@Component
public class PersonTemplate {

  private final SolrTemplate solrTemplate;
  private final String collectionName = "collection1";

  public PersonTemplate(SolrTemplate solrTemplate) {
    this.solrTemplate = solrTemplate;
  }

  protected long count(Query query) {
    return this.solrTemplate.count(collectionName, SimpleQuery.fromQuery(query));
  }

  public long count() {
    return count(new SimpleQuery(new Criteria(Criteria.WILDCARD).expression(Criteria.WILDCARD)));
  }


  public void deleteAll() {
    this.solrTemplate.delete(collectionName, new SimpleFilterQuery(new Criteria(Criteria.WILDCARD).expression(Criteria.WILDCARD)));
    this.solrTemplate.commit(this.collectionName);
  }

  public void save(Person person) {
    this.solrTemplate.saveBean(person);
    this.solrTemplate.commit(this.collectionName);
  }

  public Page<Person> findAll() {
    Pageable pageable = new SolrPageRequest(0, (int) count());
    return this.solrTemplate.queryForPage(collectionName,
        new SimpleQuery(new Criteria(Criteria.WILDCARD).expression(Criteria.WILDCARD))
            .setPageRequest(pageable),
        Person.class);
  }
}
