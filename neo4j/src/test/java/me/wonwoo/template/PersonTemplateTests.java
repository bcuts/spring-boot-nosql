package me.wonwoo.template;

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
public class PersonTemplateTests {

  @Autowired
  private PersonTemplate personTemplate;

  @Test
  public void template() {
    personTemplate.deleteAll();
    personTemplate.save(new Person("wonwoo"));
    personTemplate.save(new Person("kevin"));
    assertThat(personTemplate.findAll()).hasSize(2);
  }
}