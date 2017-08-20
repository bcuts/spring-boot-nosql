package me.wonwoo.template;

import me.wonwoo.Person;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.DeleteQuery;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;

/**
 * Created by wonwoolee on 2017. 8. 20..
 */
@Component
public class PersonTemplate {
  private final ElasticsearchTemplate elasticsearchTemplate;

  public PersonTemplate(ElasticsearchTemplate elasticsearchTemplate) {
    this.elasticsearchTemplate = elasticsearchTemplate;
  }

  public void deleteAll() {
    DeleteQuery deleteQuery = new DeleteQuery();
    deleteQuery.setQuery(matchAllQuery());
    this.elasticsearchTemplate.delete(deleteQuery, Person.class);
    this.elasticsearchTemplate.refresh(Person.class);
  }

  public void save(Person person) {
    IndexQuery indexQuery = new IndexQuery();
    indexQuery.setObject(person);
    this.elasticsearchTemplate.index(indexQuery);
    this.elasticsearchTemplate.refresh(Person.class);
  }

  public List<Person> findAll() {
    SearchQuery query = new NativeSearchQueryBuilder().withQuery(matchAllQuery()).build();
    return this.elasticsearchTemplate.queryForList(query, Person.class);
  }

}
