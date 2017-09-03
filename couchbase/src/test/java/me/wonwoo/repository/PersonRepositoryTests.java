package me.wonwoo.repository;

import me.wonwoo.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by wonwoolee on 2017. 8. 27..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTests {

  @Autowired
  private PersonRepository personRepository;

  @Test
  public void repository() {
    personRepository.deleteAll();
    personRepository.save(new Person(UUID.randomUUID().toString(),"wonwoo"));
    personRepository.save(new Person(UUID.randomUUID().toString(),"kevin"));
    assertThat(personRepository.findByName("wonwoo").get(0).getName()).isEqualTo("wonwoo");
    assertThat(personRepository.findAll()).hasSize(2);
  }

}