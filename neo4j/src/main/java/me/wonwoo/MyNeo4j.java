package me.wonwoo;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.transaction.Transaction;
import org.springframework.data.neo4j.template.Neo4jTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by wonwoolee on 2017. 8. 19..
 */
@Component
public class MyNeo4j {
  private final Neo4jTemplate neo4jTemplate;
  private final Session session;

  public MyNeo4j(Neo4jTemplate neo4jTemplate, Session session) {
    this.neo4jTemplate = neo4jTemplate;
    this.session = session;
  }

  public Collection<Account> findAccount() {
    return this.session.loadAll(Account.class);
  }
}

class Account {

}
