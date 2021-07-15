package aop.aspects;


import aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;



@Component
@Aspect
@Order(1)
public class LoggingAndSecurityAspect {
    //@Pointcut("execution( * get*())")
    //@Pointcut("execution( * add*(..))")
    @Pointcut("execution( * adc*(..))") //чтобы не засорять test2
    private void allGetMethods(){}


    //@Before("execution( * get*())")
    //@Before("allGetMethods()")
    @Before("aop.aspects.myPointcuts.allGetMethods()")
    //public void beforeGetLoggingAdvice()
    public void beforeGetLoggingAdvice(JoinPoint joinPoint)
    {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature = " + methodSignature);
        System.out.println("methodSignature.getMethod() = " + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType() = " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName = " + methodSignature.getName());

        if(methodSignature.getName().equals("addBook"))
        {
            Object[] args = joinPoint.getArgs();
            for(Object obj : args)
            {
                if (obj instanceof Book)
                {
                    Book myBook = (Book) obj;
                    System.out.println("info about book: " + myBook.getName() + " " + myBook.getAuthor() + " " +
                            myBook.getYearOfPublication());
                }
                else if(obj instanceof String)
                {
                    System.out.println("книгу а библиотеку доавляет " + obj);
                }
            }
        }

        System.out.println("beforeGetLoggingAdvice: логгирование попытки получить книгу/журнал");
    }

    //@Before("execution( * get*())")
    /*@Before("allGetMethods()")
    public void beforeGetSecurityAdvice()
    {
        System.out.println("beforeGetLoggingAdvice: проверка прав на получение книги или журнала");
    }*/



    /*
    @Pointcut("execution( * aop.UniLibrary.get*())")
    private void allGetMethodsFromUniLibrary(){}

    @Pointcut("execution( * aop.UniLibrary.return*())")
    private void allReturnMethodsFromUniLibrary(){}

    @Before("allGetMethodsFromUniLibrary()")
    public void beforeGetLoggingAdvice(){
        System.out.println("beforeGetLoggingAdvice: writing Log №1");
    }

    @Before("allReturnMethodsFromUniLibrary()")
    public void beforeReturnLoggingAdvice(){
        System.out.println("beforeReturnLoggingAdvice: writing Log №2");
    }

    @Pointcut("allGetMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary()")
    private void allGetAndReturnMethodsFromUniLibrary(){}

    @Before("allGetAndReturnMethodsFromUniLibrary()")
    public void beforeGetAndReturnLoggingAdvice(){
        System.out.println("beforeGetAndReturnLoggingAdvice: writing Log №3");
    }

    @Pointcut("execution( * aop.UniLibrary.*())")
    private void allMethodsFromUniLibrary(){}

    @Pointcut("execution( public void aop.UniLibrary.returnMagazine())")
    private void returnMagazineMethodsFromUniLibrary(){}

    @Pointcut("allMethodsFromUniLibrary() && !returnMagazineMethodsFromUniLibrary()")
    private void allMethodExceptReturnMagazineFromUniLibrary(){}

    @Before("allMethodExceptReturnMagazineFromUniLibrary()")
    public void beforeallMethodExceptReturnMagazineAdvice(){
        System.out.println("beforeallMethodExceptReturnMagazineAdvice: writing Log №10");
    }

     */

}
