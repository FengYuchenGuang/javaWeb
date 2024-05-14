package hxz.springboot.web02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 搭建三层架构，实现
 * 1、controller 控制层 接收前端请求、响应数据
 * 2、service 业务逻辑层 处理具体的业务逻辑
 * 3、dao 数据访问层 进行数据访问操作（实现增删改查）
 *
 * 进行分层解耦，降低模块之间的耦合度
 * 1、控制反转 @Component(表示一个基础的 bean)
 *    一般针对 对应层 使用相对应的 衍生容器
 *    以下都是 @Component 的衍生注解
 *    (1) @Controller    控制层
 *    (2) @Service      业务逻辑层
 *    (3) @Repository   数据访问层（与 mybatis整合，使用较少，因此
 *        该层一般用于不属于1、2、时，但又有新的模块需要加入容器时使用）
 * 2、依赖注入 @Autowired 按类型注入
 *           @Resource 按名称注入
 *    1、@Primary 有多个同类型容器，在需要装配的容器上 添加（在控制反转 @Component 上添加）
 *    2、@Autowired 自动按照类型装配
 *    3、@Resource(name = "abcempService") 按照 指定的容器名 指定注入
 *    4、@Qualifier("empServiceA")
 *       @Autowired 两者配合使用，加载指定 Bean
 *
 *
 */
//@ComponentScan({"hxz.springboot.web02"}) //默认会扫描当前包，会报注解冗余错误
@SpringBootApplication //默认扫描当前包及其子包
public class Web02Application {

    public static void main(String[] args) {
        SpringApplication.run(Web02Application.class, args);
    }

}
