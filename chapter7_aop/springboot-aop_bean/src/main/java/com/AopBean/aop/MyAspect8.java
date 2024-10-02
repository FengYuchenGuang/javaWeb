package com.AopBean.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author hxz
 */
@Slf4j
@Component //将当前类交给AOP容器管理
//@Aspect //表示当前类 为 aop 类
public class MyAspect8 {

    @Around("com.AopBean.aop.MyAspect.pt()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        log.info("\n MyAspect8 around before ... ");

        //1、获取目标对象类名
        String className = joinPoint.getTarget().getClass().getName();
        log.info("\n 目标对象的类名：{}",className);

        //2、获取目标方法方法名
        String methodName = joinPoint.getSignature().getName();
        log.info("\n 目标方法的方法名：{}",methodName);

        //3、获取目标方法运行时传入的参数
        Object[] args = joinPoint.getArgs();
        log.info("\n 目标方法的运行时传入的参数：{}", Arrays.toString(args));

        //4、放行 目标方法执行
        //5、获取目标方法运行时的返回值
        Object result = joinPoint.proceed();

        log.info("\n 目标方法运行的返回值：{}",result);


        log.info("\n MyAspect8 around after ... ");

        return result;
    }
}
