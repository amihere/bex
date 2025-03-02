package com.arachnid.bex.config;

import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableJpaRepositories
@EnableScheduling
public class AppConfig {
  private static Logger LOG = LoggerFactory.getLogger(AppConfig.class);

  @Bean
  DataSourceInitializer initializer(DataSource dataSource) {

    var initializer = new DataSourceInitializer();
    initializer.setDataSource(dataSource);

    var script = new ClassPathResource("schema.sql");
    var populator = new ResourceDatabasePopulator(script);
    initializer.setDatabasePopulator(populator);

    return initializer;
  }
}
