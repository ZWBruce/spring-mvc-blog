package com.example.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("jdbc.properties")
public class HibernateConfig {
  @Value("${jdbc.url}")
  String jdbcUrl;

  @Value("${jdbc.username}")
  String jdbcUsername;

  @Value("${jdbc.password}")
  String jdbcPassword;

  @Bean
  public DataSource createDataSource() {
    // HikariCP连接池库的一部分，用于配置和管理数据库连接池的参数
    HikariConfig config = new HikariConfig();

    config.setJdbcUrl(jdbcUrl);
    config.setUsername(jdbcUsername);
    config.setPassword(jdbcPassword);
    config.addDataSourceProperty("autoCommit", "true");
    config.addDataSourceProperty("connectionTimeout", "5");
    config.addDataSourceProperty("idleTimeout", "60");
    return new HikariDataSource(config);
  }

  // spring boot 提供的工厂类，在其他文件中使用注入的 SessionFactory 时，会使用这里的返回值
  @Bean
  LocalSessionFactoryBean sessionFactory() {
    Properties props = new Properties();
    props.setProperty("hibernate.hbm2ddl.auto", "update"); // 生产环境不要使用
    props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
    props.setProperty("hibernate.show_sql", "true");
    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    sessionFactory.setDataSource(createDataSource());
    // 扫描指定的package获取所有entity class:
    sessionFactory.setPackagesToScan("com.example.entity");
    sessionFactory.setHibernateProperties(props);
    return sessionFactory;
  }

  @Bean
  PlatformTransactionManager createTxManager(@Autowired SessionFactory sessionFactory) {
    return new HibernateTransactionManager(sessionFactory);
  }

}
