package aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {
    @Around("execution(public String returnBookForAround())")
    public Object aroundReturnBookAroundAdvice(ProceedingJoinPoint pJP) throws Throwable
    {
        System.out.println("aroundReturnBookAroundAdvice: в библиотеку " + "пытаются вернуть книгу");

        long begin = System.currentTimeMillis();
        Object proceedRes = pJP.proceed();
        proceedRes = "Преступление и наказание";
        long end = System.currentTimeMillis();
        System.out.println("aroundReturnBookAroundAdvice: в библиотеку " + "успешно вернули книгу");
        System.out.println("aroundReturnBookAroundAdvice: returnBookForAround " + " work " + (end - begin) + " ms");
        return proceedRes;

    }

}
