package aop;

import aop.aspects.SchoolLibrary;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
        UniLibrary uLib = context.getBean("uniLibrary", UniLibrary.class);
        Book book = context.getBean("book",Book.class);
        uLib.getBook();//(book);
        //uLib.getMagazine();
        //uLib.returnMagazine();

        //uLib.addBook();
        uLib.addBook("Kate", book);
        uLib.addMagazine();

        //SchoolLibrary sLIB = context.getBean("schoolLibrary", SchoolLibrary.class);
        //sLIB.getBook();

        context.close();
    }
}
