package me.wonwoo;

import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by wonwoolee on 2017. 8. 19..
 */
public interface AccountRepository extends GraphRepository<Account> {

  Account findByName(String name);
}
