package aop.aspects;

import aop.Student;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {
    @Before("execution(* getStudents())")
    public void beforeGetStudentsLoggingAdvice()
    {
        System.out.println("beforeGetStudentsLoggingAdvice: логгируем получение списка студентов перед методом getStudents");
    }


    @AfterReturning(pointcut = "execution(* getStudents())", returning = "students") //имя returning должно совпадать с
    public void afterReturningGetStudentsLoggingAdvice(List<Student> students) // именем параметра адвайса
    {
        Student firstSt = students.get(0);
        String name = firstSt.getNameSurname();
        name = "Mrs " + name;
        firstSt.setNameSurname(name);

        double avg = firstSt.getAvgGrade();
        avg = avg + 1;
        firstSt.setAvgGrade(avg);

        System.out.println("afterReturningGetStudentsLoggingAdvice: логгируем получение списка студентов после работы метода getStudents");
    }


   //@AfterThrowing("execution(* getStudents())")
   @AfterThrowing(pointcut = "execution(* getStudents())", throwing = "exeption")
    public void afterThrowingGetStudentsLoggingAdvice(Throwable exeption)
    {
        System.out.println("afterThrowingGetStudentsLoggingAdvice: логгируем выброс исключения " + exeption);
    }


}
