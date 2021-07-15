package com.kate.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
//@Scope("prototype") //("singleton")
public class Dog implements Pet {
    //private String name;

    public Dog()
    {
        System.out.println("Dog bean is created");
    }

    /*
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    */

    @PostConstruct
    public void init() //может быть и приват и протектет, не должно быть параметров
    {
        System.out.println("Class Dog: init method");
    }

    @PreDestroy
    public void destroy() //тип может быть любым,но возвращаемое значение нигде не получить,поэтому опимальнее void
    {
        System.out.println("Class Dog: destroy method");
    }

    @Override
    public void say()
    {
        System.out.println("bow-wow");
    }
}
