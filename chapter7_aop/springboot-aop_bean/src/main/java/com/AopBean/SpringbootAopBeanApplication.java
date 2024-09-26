package com.AopBean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//@ServletComponentScan //开启了 对Servlet组件的支持，才能使用 Filter 过滤器
@SpringBootApplication
public class SpringbootAopBeanApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAopBeanApplication.class, args);
    }

}
