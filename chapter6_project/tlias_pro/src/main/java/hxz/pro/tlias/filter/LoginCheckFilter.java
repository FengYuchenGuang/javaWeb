package hxz.pro.tlias.filter;

import com.alibaba.fastjson.JSONObject;
import hxz.pro.tlias.Utils.JwtUtils;
import hxz.pro.tlias.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hxz
 */
@Slf4j
//@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        //1、获取请求 url
        String url = request.getRequestURL().toString();
        log.info("请求的url: {}",url);

        //2、判断请求 url中是否包含 login，如果包含 说明是登录操作，放行
        if(url.contains("login")){
            log.info("登录操作，放行~~~");
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        //3、获取请求头中的令牌（token）
        String token = request.getHeader("token");

        //4、判断令牌是否存在，如果不存在 返回错误信息（未登录）
        if(!StringUtils.hasLength(token)){ //判断字符串是否有长度
            log.info("请求头token为空，返回未登录信息");
            Result error = Result.error("NOT_LOGIN");
            //手动转换 对象--JSON
            String notlogin = JSONObject.toJSONString(error);
            response.getWriter().write(notlogin);
            return;
        }

        //5、解析token，如果解析失败，返回错误结果（登录失败）
        try {
            JwtUtils.parseJwt(token);
        } catch (Exception e) {// jwt令牌解析失败
            e.printStackTrace();
            log.info("令牌解析失败,返回未登录信息~~~");
            Result error = Result.error("NOT_LOGIN");
            //手动转换 对象--JSON
            String notlogin = JSONObject.toJSONString(error);
            response.getWriter().write(notlogin);
            return;
        }

        //6、放行
        log.info("令牌合法，放行~~~");
        filterChain.doFilter(servletRequest,servletResponse);

    }
}
