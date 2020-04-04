package com.shravan.learn.spring.aop.aspect;

import com.shravan.learn.spring.aop.model.Triangle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Annotation for creating aspect
 */
@Aspect
public class LoggingAspect {

    /**
     * Advice - terminology in AOP
     * Execute only public method getName() of class Triangle
     * Not executed by Spring Container when Spring Bean is initialized in container (using setters or Constructors)
     * JoinPoint - terminology in AOP
     * All places in code where Advice can be applied
     */
    @Before("execution(public String com.shravan.learn.spring.aop.model.Triangle.getName())")
    public void LoggingTriangleOnlyAdvice(JoinPoint joinPoint) {
        final Triangle triangle = (Triangle) joinPoint.getTarget();
        System.out.println("LoggingAspect.LoggingTriangleOnlyAdvice " + joinPoint.toString() + " " + triangle.getName());
    }

    /**
     * Wildcards - Execute public method with get in method name with any return type and no arguments
     */
    @Before("execution(public * get*())")
    public void LoggingGettersNoArgsAdvice() {
        System.out.println("LoggingAspect.LoggingGettersNoArgsAdvice");
    }

    /**
     * Wildcards -
     * .. - no arguments or any number of arguments
     * * - one or more arguments
     */
    @Before("execution(public * get*(..))")
    public void LoggingGettersArgsAdvice() {
        System.out.println("LoggingAspect.LoggingGettersArgsAdvice");
    }

    /**
     * Pointcut - terminology in AOP
     * expression for which methods will be called
     * Pointcut expression can be used in other Advice methods
     */
    @Pointcut("execution(public * set*(..))")
    public void allSetters() {

    }

    @Before("allSetters()")
    public void LoggingSettersAdvice() {
        System.out.println("LoggingAspect.LoggingSettersAdvice ");
    }

    @Before("allSetters() && allCircleMethods()")
    public void LoggingSettersAnotherAdvice() {
        System.out.println("LoggingAspect.LoggingSettersAnotherAdvice");
    }

    @Pointcut("within(com.shravan.learn.spring.aop.model.Circle)")
    public void allCircleMethods() {

    }

    /**
     * Execute Advice after executing the method
     * Use @AfterReturning for executing Advice after successfully executing method
     * Use @AfterThrowing for executing Advice affter method throws exception
     * Use @After for executing Advice at all times like the finally block
     */
    @After("args(name)")
    public void stringArgumentMethods(String name) {
        System.out.println("LoggingAspect.stringArgumentMethods " + name);
    }

    @AfterReturning(pointcut = "args(name)", returning = "newName")
    public void LoggingSettersParametersAdvice(String name, String newName) {
        System.out.println("LoggingAspect.LoggingSettersParametersAdvice " + name + " " + newName);
    }

    @Around("allSetters()")
    public Object LoggingAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("LoggingAspect.LoggingAroundAdvice Before");
        /**
         * Execution of target method
         */
        final Object proceed = proceedingJoinPoint.proceed();
        System.out.println("LoggingAspect.LoggingAroundAdvice After");
        return proceed;
    }

    @After("@annotation(com.shravan.learn.spring.aop.aspect.Loggable)")
    public void Loggable() {
        System.out.println("LoggingAspect.Loggable");
    }

    @Around("@annotation(com.shravan.learn.spring.aop.aspect.LogTime)")
    public Object LogTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        final Object proceed = proceedingJoinPoint.proceed();
        long end = System.nanoTime();
        long timeTaken = (end - start);
        System.out.println(proceedingJoinPoint.getSignature().getDeclaringType() + "." + proceedingJoinPoint.getSignature().getName() + " timeTaken = " + timeTaken + " ns");
        return proceed;

    }
}
