package edu.javacourse.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Author: Georgy Gobozov
 * Date: 19.07.13
 */
@Aspect
public class Logging {

    // pointcut аннтотации содержат в себе выражения, обозначающие, какие методы будут вызваны
    // сам метод просто маркер-ориентир для советов (advice) @Before, @After

    @Pointcut("execution(* edu.javacourse.spring.bean.RegionManager.get*(..))")
    private void getAnything(){}

    @Pointcut("execution(* edu.javacourse.spring.bean.CityManager.*City(..))")
    private void actionWithCity(){}

    @Pointcut("execution(* edu.javacourse.spring.bean.RegionManager.*(String,..)) && args(s)")
    private void allRegionManagerMethods(String s){}

    @Pointcut("bean(buildingManager)")
    private void allMethodInBean(){}


    @Before("getAnything()")
    public void doBeforeGetAnything(JoinPoint joinPoint){
        System.out.println("LOG POINTCUT 1: GET method called of " + joinPoint.getTarget().getClass().getName());
    }

    @After("actionWithCity()")
    public void doAfterAnyActionCity(JoinPoint joinPoint){
        System.out.println("LOG POINTCUT 2: CityManager method " + joinPoint.getSignature().getName() + " called, ends witt 'City'");
    }

    @Before("allRegionManagerMethods(String)")
    public void doBeforeAnyActionRegion(JoinPoint joinPoint){
        System.out.println("LOG POINTCUT 3: RegionManager method " + joinPoint.getSignature().getName() + " with STRING argument called");
    }

    @After("allMethodInBean()")
    public void doAfterWithBean(JoinPoint joinPoint){
        System.out.println("LOG POINTCUT 4: buildingManager method " + joinPoint.getSignature().getName() + " called");
    }

}
