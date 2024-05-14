package hxz.springboot.web02.dao;

import hxz.springboot.web02.pojo.Emp;
import hxz.springboot.web02.utils.XmlParserUtils;

import java.util.List;

/**
 * @author hxz
 * 三层架构， 3、数据访问层 ，实现 数据操作 功能
 */
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
