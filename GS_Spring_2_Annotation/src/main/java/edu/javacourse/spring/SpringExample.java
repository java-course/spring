package edu.javacourse.spring;

import edu.javacourse.spring.bean.BeanExample;
import edu.javacourse.spring.bean.SpringAnnotatedConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExample {

    public static void main(String[] args) {
        SpringExample se = new SpringExample();
        se.demoSpring();
    }
    
    public void demoSpring() {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springExample.xml"});

        // Обратить внимание на то. что объект создается через вызов метода
        BeanExample be = context.getBean(BeanExample.class);
        System.out.println("Basic string:" + be.getBasicString());
        System.out.println("Other String:" + be.getOtherString());
        System.out.println("Spring test:" + be.getSpringTest());
        
        System.out.println();

    }
}
