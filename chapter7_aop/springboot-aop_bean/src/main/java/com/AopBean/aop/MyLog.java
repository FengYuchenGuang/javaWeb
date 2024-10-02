package com.AopBean.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author hxz
 */
@Retention(RetentionPolicy.RUNTIME) //运行时有效
@Target(ElementType.METHOD) //作用域 -- 方法上
public @interface MyLog {
}
