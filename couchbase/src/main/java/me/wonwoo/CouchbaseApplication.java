package me.wonwoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

/**
 * Created by wonwoolee on 2017. 8. 27..
 */
@SpringBootApplication
public class CouchbaseApplication {

  public static void main(String[] args) {
    SpringApplication.run(CouchbaseApplication.class, args);
  }
}
