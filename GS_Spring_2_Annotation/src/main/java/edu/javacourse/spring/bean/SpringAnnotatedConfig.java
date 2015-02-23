package edu.javacourse.spring.bean;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringAnnotatedConfig {

    // Создание объекта через метод
    @Bean
    public BeanExample beanService() {
        System.out.println("BeanExample through method");
        return new BeanExample();
    }
    

}
