package hxz.springboot.web02.service;

import hxz.springboot.web02.pojo.Emp;

import java.util.List;

/**
 * @author hxz
 */
public interface BasicService {
    //获取员工列表
    public List<Emp> listEmp();
}
