package com.kate.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Test6 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
        /*Person per = context.getBean("PersonBean", Person.class);
        per.callYourPet();*/
        Pet c = context.getBean("catBean", Pet.class);
        c.say();
        //Pet c2 = context.getBean("catBean", Pet.class);
        //c2.say();

        Person p = context.getBean("personBean", Person.class);
        p.callYourPet();
        System.out.println(p.getSurname());
        System.out.println(p.getAge());

        context.close();
    }
}
