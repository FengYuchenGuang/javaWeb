package hxz.mybatis.mybatis01;

import hxz.mybatis.mybatis01.mapper.UserMapper;
import hxz.mybatis.mybatis01.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest //springboot整合单元测试注解
class Mybatis01ApplicationTests {

//    @Resource //按名称注入 （UserMapper 那里不需要添加 bean 进行控制反转）
    /**
     * 按类型注入 需要在 对应 UserMapper 那里进行控制反转
     *  以下都是 @Component 的衍生注解
     *  (1) @Controller    控制层
     *  (2) @Service      业务逻辑层
     *  (3) @Repository   数据访问层（与 mybatis整合，使用较少，因此
     *         该层一般用于不属于1、2、时，但又有新的模块需要加入容器时使用）
     */
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testListUser(){
        List<User> userList = userMapper.list();
        userList.stream().forEach(user -> {
            System.out.println(user);
        });
    }

    @Test
    public void testJdbc() throws Exception {
        //1. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2. 获取连接对象
        String url = "jdbc:mysql://localhost:3306/mybatis?useSSL=false";
        String username = "root";
        String password = "hxz";
        Connection connection = DriverManager.getConnection(url, username, password);

        //3. 获取执行SQL的对象Statement,执行SQL,返回结果
        String sql = "select * from user";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        //4. 封装结果数据
        List<User> userList = new ArrayList<>();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            short age = resultSet.getShort("age");
            short gender = resultSet.getShort("gender");
            String phone = resultSet.getString("phone");

            User user = new User(id,name,age,gender,phone);
            userList.add(user);
        }

        userList.stream().forEach(user -> {
            System.out.println(user);
        });

        //5. 释放资源
        statement.close();
        connection.close();
    }
}
