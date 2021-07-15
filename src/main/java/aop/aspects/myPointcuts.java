package aop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class myPointcuts {
    //@Pointcut("execution( * get*())") // .. - любое количество параметров
    //@Pointcut("execution( * add*(..))")
    @Pointcut("execution( * adc*(..))") //чтобы не засорять test2
    public void allGetMethods(){}
}
