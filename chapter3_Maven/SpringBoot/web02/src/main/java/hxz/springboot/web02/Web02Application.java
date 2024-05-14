package hxz.springboot.web02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 搭建三层架构，实现
 * 1、controller 控制层 接收前端请求、响应数据
 * 2、service 业务逻辑层 处理具体的业务逻辑
 * 3、dao 数据访问层 进行数据访问操作（实现增删改查）
 */
@SpringBootApplication
public class Web02Application {

    public static void main(String[] args) {
        SpringApplication.run(Web02Application.class, args);
    }

}
