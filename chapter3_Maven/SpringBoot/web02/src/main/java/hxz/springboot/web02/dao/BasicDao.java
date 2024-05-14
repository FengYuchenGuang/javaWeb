package hxz.springboot.web02.dao;

import hxz.springboot.web02.pojo.Emp;

import java.util.List;

/**
 * @author hxz
 * 接口
 */
public interface BasicDao {
    //获取员工列表数据
    public List<Emp> listEmp();
}
