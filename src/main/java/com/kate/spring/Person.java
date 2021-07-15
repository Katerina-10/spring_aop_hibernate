package com.kate.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("PersonBean")
public class Person {

    //@Autowired
    private Pet p;
    @Value("${person.surname}")
    private String surname;
    @Value("${person.age}")
    private int age;

    public void setAge(int age) {
        System.out.println("setAge");
        this.age = age;
    }

    public void setSurname(String surname) {
        System.out.println("setSurname");
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public String getSurname() {
        return surname;
    }

    //@Autowired
    //public Person(@Qualifier("catBean") Pet p) {
    public Person( Pet p) {
        System.out.println("Person bean is created");
        this.p = p;
    }

    /*public Person()
    {
        System.out.println("Person bean is created");
    }*/

    //@Autowired // зависимость Person от Pet  (можно не только в сеттере, а в любом методе, где есть зависимость)
    public void setP(Pet p) {
        System.out.println("class Person: set pet");
        this.p = p;
    }



    public void callYourPet()
    {
        System.out.println("hello, my lovely pet");
        p.say();
    }
}
