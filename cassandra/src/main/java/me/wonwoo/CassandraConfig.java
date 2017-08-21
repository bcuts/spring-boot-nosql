package me.wonwoo;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by wonwoolee on 2017. 8. 21..
 */

@Configuration
class CassandraConfig extends AbstractCassandraConfiguration {

  private static final String KEYSPACE_NAME = CassandraConfig.class.getSimpleName().toLowerCase();

  private static final String CREATE_PERSON_KEYSPACE_DEFINITION_CQL = String
      .format("CREATE KEYSPACE %s WITH REPLICATION = {'class' : 'SimpleStrategy', 'replication_factor': 3};", KEYSPACE_NAME);


  private static final String DROP_PERSON_KEYSPACE_DEFINITION_CQL = String
      .format("DROP KEYSPACE %s;", KEYSPACE_NAME);

  @Override
  public String getKeyspaceName() {
    return KEYSPACE_NAME;
  }

  @Override
  public SchemaAction getSchemaAction() {
    return SchemaAction.RECREATE;
  }

  @Override
  public List<String> getStartupScripts() {
    return Arrays.asList(DROP_PERSON_KEYSPACE_DEFINITION_CQL, CREATE_PERSON_KEYSPACE_DEFINITION_CQL);
  }
}
