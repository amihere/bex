package com.arachnid.bex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableJpaRepositories
@EnableScheduling
public class AppConfig {
  private static Logger LOG = LoggerFactory.getLogger(AppConfig.class);
}
