package edu.javacourse.spring.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class ContextAware implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        this.applicationContext = ac;
        System.out.println("applicationContext name = " + ac.getDisplayName());
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
