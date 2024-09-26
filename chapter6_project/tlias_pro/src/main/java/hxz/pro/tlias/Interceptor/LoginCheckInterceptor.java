package hxz.pro.tlias.Interceptor;

import com.alibaba.fastjson.JSONObject;
import hxz.pro.tlias.Utils.JwtUtils;
import hxz.pro.tlias.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hxz
 */
@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override //目标资源方法运行前运行，返回 true 放行，返回 false 不放行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle ~~~");

        /**
         * 可以在 WebConfig 中设置 不拦截 login
         */
//        //1、获取请求 url
//        String url = request.getRequestURL().toString();
//        log.info("请求的url: {}",url);
//
//        //2、判断请求 url中是否包含 login，如果包含 说明是登录操作，放行
//        if(url.contains("login")){
//            log.info("登录操作，放行~~~");
//            return true;
//        }

        //3、获取请求头中的令牌（token）
        String token = request.getHeader("token");

        //4、判断令牌是否存在，如果不存在 返回错误信息（未登录）
        if(!StringUtils.hasLength(token)){ //判断字符串是否有长度
            log.info("请求头token为空，返回未登录信息");
            Result error = Result.error("NOT_LOGIN");
            //手动转换 对象--JSON
            String notlogin = JSONObject.toJSONString(error);
            response.getWriter().write(notlogin);
            return false;
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
            return false;
        }

        //放行
        return true;
    }

    @Override //目标资源方法运行后运行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle ~~~");

    }

    @Override //视图渲染完毕后运行，最后运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion ~~~");

    }
}
