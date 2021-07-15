package com.kate.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("appContext3.xml");

        Dog d = context.getBean("dog", Dog.class);
        /*Dog d2 = context.getBean("dog", Dog.class);

        System.out.println(" & == ? " + (d == d2) );
        System.out.println(d);
        System.out.println(d2);*/
        d.say();

        context.close();

    }
}
