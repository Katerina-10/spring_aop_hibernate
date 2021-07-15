package com.kate.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigWhithAnnotations1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("appContext3.xml");
        //Cat c = context.getBean("cat", Cat.class); //как класс Cat, только с маленькой - если дефолтный id бина (не указан явно)
        //Cat c = context.getBean("catBean", Cat.class);
        //c.say();

        Person p = context.getBean("PersonBean", Person.class);
        p.callYourPet();

        context.close();
    }
}
