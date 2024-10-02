package com.AopBean.controller;


import com.AopBean.Utils.JwtUtils;
import com.AopBean.pojo.Emp;
import com.AopBean.pojo.Result;
import com.AopBean.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hxz
 */
@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping
    public Result login(@RequestBody Emp emp){
        log.info("员工登录 ：{}",emp);
        Emp e = empService.login(emp);

        //登录成功 -> 生成令牌，下发令牌
        if(e != null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id",e.getId());
            claims.put("name",e.getName());
            claims.put("username",e.getUsername());

            String jwt = JwtUtils.generateJwt(claims);

            return Result.success(jwt);
        }

        //登录失败 -> 返回错误信息
        return Result.error("用户名或密码错误！！！");
    }

}
