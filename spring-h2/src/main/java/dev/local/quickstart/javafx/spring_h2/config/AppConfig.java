package dev.local.quickstart.javafx.spring_h2.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan("dev.local")
@PropertySources({
    @PropertySource("classpath:application.properties")
})
@Slf4j
public class AppConfig {

  @Autowired
  private Environment env;

  @Bean
  public BasicDataSource basicDataSource() throws Exception {
    try {
      BasicDataSource connectionPool = new BasicDataSource();
      connectionPool.setUsername(strFromProp("db.username", ""));
      connectionPool.setPassword(strFromProp("db.pass", ""));
      connectionPool.setDriverClassName(strFromProp("db.driverClassName", ""));
      connectionPool.setUrl(strFromProp("db.url", ""));
      connectionPool.setValidationQuery(strFromProp("db.validationQuery", ""));
      connectionPool.setInitialSize(intFromProp("db.initialSize", 1));
      connectionPool.setMaxActive(intFromProp("db.maxActive", 1));
      connectionPool.setMaxIdle(intFromProp("db.maxIdle", 1));
      connectionPool.setMinIdle(intFromProp("db.minIdle", 0));
      return connectionPool;
    } catch (Exception e) {
      log.error("init pool error: {}", e);
      throw new Exception(e);
    }
  }

  /* util */
  private String strFromProp(String key, String defaultValue) {
    if (env.getProperty(key) != null) return env.getProperty(key);
    else return defaultValue;
  }

  private Integer intFromProp(String key, Integer defaultValue) {
    if (env.getProperty(key) != null) return Integer.valueOf(env.getProperty(key));
    else return defaultValue;
  }
}