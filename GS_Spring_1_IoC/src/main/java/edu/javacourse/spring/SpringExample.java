package edu.javacourse.spring;

import edu.javacourse.spring.bean.*;
import edu.javacourse.spring.bean.init.InitBean1;
import edu.javacourse.spring.bean.init.InitBean2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExample {

    public static void main(String[] args) {
        SpringExample se = new SpringExample();
        se.demoSpring();
    }
    
    public void demoSpring() {


        // пример, показывающий каким образом можно проинициализировать бины и уничтожить их.
        //test0();

       // test1();

       // test2();

       // test3();

        // test4();

       test5();


    }

    private void test0() {
        ApplicationContext context =  new ClassPathXmlApplicationContext(new String[]{"test0.xml"});
        // Вызов бинов с постинициализацией и преддестроем
        // Получение бина способом приведения

        InitBean1 init1 = (InitBean1) context.getBean("init1");
        InitBean2 init2 =  context.getBean("init2", InitBean2.class);

        // Надо привести к типу ClassPathXmlApplicationContext для использования destroy
        ((ClassPathXmlApplicationContext)context).destroy();

        //попробуйте потом закоментить бин init1 и init2, оставив только первую строку инициализации контекста, вы
        // вы увидете, что первые бин проинициализируется контекстом, второй нет, так как у него lazy-init="true"

    }

    private void test1() {
        ApplicationContext context =  new ClassPathXmlApplicationContext(new String[]{"test1.xml"});
        // Пример вызова бина, который указан в конфигурационном файле
        // Получение бина с помощью класса, нет приведения типов
        SpringTest st = context.getBean("testSpringBean", SpringTest.class);

        System.out.println(st.getNumber());
        System.out.println(st.getChild().getHello());
        System.out.println(st.getOtherChild().getHello());
    }


    private void test2() {
        ApplicationContext context =  new ClassPathXmlApplicationContext(new String[]{"test2.xml"});
        // Вызов бина с внутренним описанием еще одного бина
        SpringTest stInner = context.getBean("outerbean", SpringTest.class);
        System.out.println(stInner.getNumber());
        System.out.println(stInner.getChild().getHello());
    }

    private void test3() {
        // Создание обхекта через статический вызов
        ApplicationContext context =  new ClassPathXmlApplicationContext(new String[]{"test3.xml"});
        SpringTestInstance test2 = context.getBean("instanceBean1", SpringTestInstance.class);
        test2.sayHello();

        SpringTestInstance test3 = context.getBean("instanceBean2", SpringTestInstance.class);
        test3.sayHello();
        // объект фактически создается только один раз, но уже через наш factory-method
    }


    private void test4() {
        ApplicationContext context =  new ClassPathXmlApplicationContext(new String[]{"test4.xml"});
        // Создание обхекта с указанием параметров в конструкторе
        SpringTestConstructor test4 = context.getBean("constructorBean", SpringTestConstructor.class);
        System.out.println(test4.getNumber());
        System.out.println(test4.getName());
        System.out.println(test4.getTest().getNumber());
        System.out.println(test4.getTest().getChild().getHello());
    }



    private void test5() {
        ApplicationContext context =  new ClassPathXmlApplicationContext(new String[]{"test5.xml"});
        // List example

        SpringList springList = (SpringList)context.getBean("listBean");
        for (String s : springList.getStringList()) {
            System.out.println("List item = " + s);
        }


        // Инициализация свойства типа Map
        SpringMap test5 = context.getBean("testMap", SpringMap.class);
        System.out.println("===> Map");
        for (String s : test5.getAccounts().keySet()) {
            Float f = test5.getAccounts().get(s);
            System.out.println(s + ":" + f);
        }
        System.out.println();
        System.out.println();
    }






}
