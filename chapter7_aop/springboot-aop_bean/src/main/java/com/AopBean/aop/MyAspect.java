package com.AopBean.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author hxz
 */
@Component
@Aspect
@Slf4j
public class MyAspect {

    /**
     * 切入点表达式抽取
     *
     * private 只有自己能使用
     * public 则其他切面类中可以使用
     *
     */
    @Pointcut("execution(* com.AopBean.service.impl.DeptServiceImpl.*(..))")
    public void pt(){}


    /**
     * 学习切入点表达式如何写
     */
    @Pointcut("execution(* com.AopBean.service.*.*(..))")
    public void pt2(){}


    @Before("execution(* com.AopBean.service.impl.DeptServiceImpl.*(..))")
    public void before(){
        log.info("before ... ");
    }

    @Around("pt()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("around before ... ");

        Object result = joinPoint.proceed();

        log.info("around after ... ");

        return result;
    }

    @After("pt()")
    public void after(){
        log.info("after ... ");
    }

    @AfterReturning("pt()")
    public void afterReturning(){
        log.info("beforeReturning ... ");
    }

    @AfterThrowing("pt()")
    public void afterThrowing(){
        log.info("afterThrowing ... ");
    }
}
