package edu.javacourse.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;

public class BeanExample {

    @Value("String for BeanExample")
    private String basicString;

    // Здесь пример вызова значения из файла свойств (см. файл springExample.xml
    // Expression Language
    @Value("#{springProperties.initialize}")
    private String otherString;
    //

    @Autowired
    //@Qualifier(value="testSpringBean")  // Без указания конкретного бина Spring запутается
    private SpringTest springTest;

    public String getBasicString() {
        return basicString;
    }

    public void setBasicString(String basicString) {
        this.basicString = basicString;
    }

    // Пример с аннотацией PostConstruct
    @PostConstruct
    public void postConstruct() {
        System.out.println("Post Construct");
    }

    public String getOtherString() {
        return otherString;
    }

    public SpringTest getSpringTest() {
        return springTest;
    }

    public void setOtherString(String otherString) {
        this.otherString = otherString;
    }

    public void setSpringTest(SpringTest springTest) {
        this.springTest = springTest;
    }
}
