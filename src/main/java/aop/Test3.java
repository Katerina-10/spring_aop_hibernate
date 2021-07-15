package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        System.out.println("Main start");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
        String bookName = uniLibrary.returnBookForAround();
        System.out.println("В библиотеку вернули книгу " + bookName);
        System.out.println("Main end");

        context.close();
    }
}
