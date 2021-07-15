package com.kate.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        /*Pet p = new Dog();
        Person per = new Person(p);
        per.callYourPet();*/

        ClassPathXmlApplicationContext cont =
                new ClassPathXmlApplicationContext("appContext.xml");
        /*Pet p = cont.getBean("myPet", Pet.class);
        Person per = new Person(p);
        per.callYourPet();*/

        Person person = cont.getBean("myPerson", Person.class);
        person.callYourPet();

        System.out.println(person.getAge());
        System.out.println(person.getSurname());

        cont.close();


    }
}
