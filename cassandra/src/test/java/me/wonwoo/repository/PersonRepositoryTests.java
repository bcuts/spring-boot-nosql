package me.wonwoo.repository;

import com.datastax.driver.core.utils.UUIDs;
import me.wonwoo.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.cassandra.repository.support.BasicMapId;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

/**
 * Created by wonwoolee on 2017. 8. 21..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTests {

  @Autowired
  private PersonRepository personRepository;

  @Test
  public void repository() {
    personRepository.deleteAll();
    personRepository.save(new Person(UUIDs.timeBased(),"wonwoo"));
    personRepository.save(new Person(UUIDs.timeBased(),"kevin"));
    assertThat(personRepository.findByName("wonwoo").getName()).isEqualTo("wonwoo");
    assertThat(personRepository.findAll()).hasSize(2);
  }

}