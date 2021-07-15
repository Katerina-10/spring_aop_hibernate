package com.kate.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext cont =
                new ClassPathXmlApplicationContext("appContext.xml");
        Pet p = cont.getBean("myPet", Pet.class);
        p.say();
        cont.close();
    }
}
