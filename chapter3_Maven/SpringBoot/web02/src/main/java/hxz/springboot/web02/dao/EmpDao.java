package hxz.springboot.web02.dao;

import hxz.springboot.web02.pojo.Emp;
import hxz.springboot.web02.utils.XmlParserUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hxz
 * 三层架构， 3、数据访问层 ，实现 数据操作 功能
 */
//@Component //将当前对象交给IOC容器管理,成为IOC容器的bean
@Repository//("daoA") //定义该容器的容器名
public class EmpDao implements BasicDao{

    @Override
    public List<Emp> listEmp() {
        //1. 加载并解析emp.xml
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);

        return empList;
    }
}
