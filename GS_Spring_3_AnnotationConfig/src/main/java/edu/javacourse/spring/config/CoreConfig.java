package edu.javacourse.spring.config;

import edu.javacourse.spring.bean.SimpleBean1;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ImportResource("classpath:config.xml")
public class CoreConfig {

    private @Value("${jdbc.url}") String url;
    private @Value("${jdbc.username}") String username;
    private @Value("${jdbc.password}") String password;

    @Bean(name = "datasourse")
    public DataSource dataSource() {
        return new DriverManagerDataSource(url, username, password);
    }

    // Здесь могут быть интерфейсы вместо классов - что может быть удобно !!!
    @Bean
    public SimpleBean1 getSimpleBean1() {
        return new SimpleBean1();
    }





}
