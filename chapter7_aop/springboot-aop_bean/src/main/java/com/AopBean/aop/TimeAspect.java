package com.AopBean.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author hxz
 */
@Slf4j
@Component //将当前类交给AOP容器管理
@Aspect //表示当前类 为 aop 类
public class TimeAspect {

    /**加在那个方法上
     * 切入点表达式
     */
//    @Around("execution(* com.AopBean.service.*.*(..))")
    @Around("com.AopBean.aop.MyAspect.pt2()")
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable{
        //1、记录开始时间
        long begin = System.currentTimeMillis();

        //2、调用原始方法
        Object proceed = joinPoint.proceed();

        //3、记录结束时间
        long end = System.currentTimeMillis();
        log.info("\n "+joinPoint.getSignature()+"方法执行耗时: {} ms",end-begin);

        return proceed;
    }


}
