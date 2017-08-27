package me.wonwoo;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.solr.SolrProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.solr.core.SolrTemplate;

/**
 * Created by wonwoolee on 2017. 8. 26..
 */
@SpringBootApplication
public class SolrApplication {

  public static void main(String[] args) {
    SpringApplication.run(SolrApplication.class, args);
  }

  @Bean
  public SolrClient solrClient(SolrProperties solrProperties) {
    return new HttpSolrClient(solrProperties.getHost());
  }

  @Bean
  public SolrTemplate solrTemplate() {
    return new SolrTemplate(solrClient(null));
  }
}
