package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.remoting.soap.SoapFaultException;

import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        University uni = context.getBean("university", University.class);
        uni.addStudent();
        try {
            List<Student> students = uni.getStudents();
            System.out.println(students);
        }
        catch (Exception e)
        {
            System.out.println("было поймано исключение " + e);
        }

        context.close();
    }
}
