package com.AopBean.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author hxz
 */
@Component //将当前类交给AOP容器管理
@Aspect //表示当前类 为 aop 类
public class TimeAspect {
}
