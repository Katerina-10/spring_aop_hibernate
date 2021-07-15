package com.kate.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("appContext2.xml");

        Dog d = context.getBean("myPet", Dog.class);
        //d.setName("belka");
        Dog d2 = context.getBean("myPet", Dog.class);
        //d2.setName("strelka");

        //System.out.println(d.getName());
        //System.out.println(d2.getName());
        System.out.println("переменные ссылаются на один и тот же объескт? " + (d == d2));
        System.out.println(d);
        System.out.println(d2);

        context.close();

    }
}
