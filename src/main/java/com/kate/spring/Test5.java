package com.kate.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test5 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("appContext2.xml");

        Dog d = context.getBean("myPet", Dog.class);
        d.say();

        Dog d2 = context.getBean("myPet", Dog.class);
        d.say();

        context.close();

    }
}
