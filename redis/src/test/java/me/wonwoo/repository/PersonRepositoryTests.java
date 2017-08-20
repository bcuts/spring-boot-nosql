package me.wonwoo.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by wonwoolee on 2017. 8. 20..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTests {

  @Autowired
  private PersonRepository personRepository;

  @Test
  public void repository() {
    personRepository.deleteAll();
    personRepository.save(new Person("wonwoo"));
    personRepository.save(new Person("kevin"));
    personRepository.findAll()
        .forEach(System.out::println);
  }
}