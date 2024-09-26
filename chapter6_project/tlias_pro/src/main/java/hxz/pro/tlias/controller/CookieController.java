package hxz.pro.tlias.controller;

import hxz.pro.tlias.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hxz
 */
@Slf4j
@RestController
public class CookieController {

    //设置Cookie
    @GetMapping("/c1")
    public Result cookie1(HttpServletResponse response){
        response.addCookie(new Cookie("login_name", "hxz"));
        return Result.success();
    }

    //获取Cookie
    @GetMapping("/c2")
    public Result cookie2(HttpServletRequest request){
        Cookie[] cookies = request.getCookies(); //获取所有的Cookie
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("login_name")){
                log.info("login_name : {}", cookie.getValue());
            }
        }
        return Result.success();
    }
}
