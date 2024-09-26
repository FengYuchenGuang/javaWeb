package hxz.pro.tlias.controller;

import hxz.pro.tlias.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author hxz
 */
@Slf4j
@RestController
public class SessionController {

    //在 HttpSession 中设置值
    @GetMapping("/s1")
    public Result cookie1(HttpSession session){
        log.info("HttpSession-s1 : {}", session.hashCode());

        session.setAttribute("login_name", "hxz");

        return Result.success();
    }

    //从 HttpSession 中获取值
    @GetMapping("/s2")
    public Result cookie2(HttpServletRequest request){
        HttpSession session = request.getSession();
        log.info("HttpSession-s2 : {}", session.hashCode());

        Object loginuser = session.getAttribute("login_name"); //获取所有的Cookie
        log.info("login_name : {}", loginuser);

        return Result.success();
    }


}
