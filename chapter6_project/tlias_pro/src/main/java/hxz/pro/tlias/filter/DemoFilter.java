package hxz.pro.tlias.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author hxz
 * 过滤器使用细节
 *
 * 也可以使用多个过滤器 组成 过滤器链
 * 过滤器的优先级与 过滤器类名有关
 *
 */
@Slf4j
@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("\n Filter init方法执行了~~~");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("拦截到了请求~~~放行前逻辑");

        /**
         * 校验，判断是否放行
         */


        filterChain.doFilter(servletRequest,servletResponse); //放行

        log.info("拦截到了请求~~~放行后逻辑");

    }

    @Override
    public void destroy() {
        log.info("\n Filter destroy方法执行了~~~");

    }
}
