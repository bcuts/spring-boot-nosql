package me.wonwoo.template;

import com.datastax.driver.core.utils.UUIDs;
import me.wonwoo.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

/**
 * Created by wonwoolee on 2017. 8. 21..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonTemplateTests {

  @Autowired
  private PersonTemplate personTemplate;

  @Test
  public void template() {
    personTemplate.deleteAll();
    personTemplate.save(new Person(UUIDs.timeBased(), "wonwoo"));
    personTemplate.save(new Person(UUIDs.timeBased(),"kevin"));
    assertThat(personTemplate.findAll()).hasSize(2);
  }
}