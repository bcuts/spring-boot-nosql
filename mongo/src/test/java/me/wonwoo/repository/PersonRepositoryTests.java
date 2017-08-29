package me.wonwoo.repository;

import me.wonwoo.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

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
    assertThat(personRepository.findByName("wonwoo").getName()).isEqualTo("wonwoo");
    assertThat(personRepository.findAll()).hasSize(2);
  }
}