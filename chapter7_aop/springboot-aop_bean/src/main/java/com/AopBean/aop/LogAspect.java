package com.AopBean.aop;

import com.AopBean.Utils.JwtUtils;
import com.AopBean.mapper.OperateLogMapper;
import com.AopBean.pojo.OperateLog;
import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author hxz
 */
@Component
@Aspect
@Slf4j
public class LogAspect {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(com.AopBean.anno.hxzLog)")
    public Object recodLog(ProceedingJoinPoint joinPoint) throws Throwable {

        //操作人ID--获取请求头中的JWT令牌，解析获得
        String token = request.getHeader("token");
        Claims claims = JwtUtils.parseJwt(token);
        Integer operateUser = (Integer) claims.get("id");

        //操作时间
        LocalDateTime operateTime = LocalDateTime.now();

        //操作类名
        String className = joinPoint.getTarget().getClass().getName();

        //操作方法名
        String methodName = joinPoint.getSignature().getName();

        //操作方法参数
        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args);


        //操作方法返回值
        long begin = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();

        String returnValue = JSONObject.toJSONString(result);

        //操作耗时
        Long costTime = end - begin;


        /**
         * 记录操作日志
         */
        OperateLog operateLog = new OperateLog(null,operateUser,operateTime,className,methodName,methodParams,returnValue,costTime);

        log.info("\n\n AOP 记录操作日志 ：{}\n",operateLog);
        operateLogMapper.insert(operateLog);

        return result;
    }

}
