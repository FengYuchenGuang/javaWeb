package com.AopBean.service.impl;


import com.AopBean.aop.MyLog;
import com.AopBean.mapper.DeptMapper;
import com.AopBean.mapper.EmpMapper;
import com.AopBean.pojo.Dept;
import com.AopBean.pojo.DeptLog;
import com.AopBean.service.DeptLogService;
import com.AopBean.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author hxz
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private DeptLogService deptLogService;

    @MyLog //自己写的注解，AOP中另一种切入点方法
    @Override
    public List<Dept> list() {

        List<Dept> list = deptMapper.list();
        return list;
    }

    /**
     * 开启事务，删除部门时，同时删除该部门所有员工
     * 两者只有同时成功，或同时失败
     *
     * 开启事务， @Transactional 默认情况下，只有 运行时异常 会回滚
     *
     * 设置 rollbackFor
     * @Transactional(rollbackFor = Exception.class)
     *
     * 此时所有异常都会回滚
     * 提交 或者 事务回滚
     */

    /**
     * 如何记录日志 （在 finally 中 记录 即 不论成功与否都记录日志）
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int delete(Integer id) {

        int row;
        try {
            row = deptMapper.deleteById(id);
//            int i = 1 / 0; //抛出异常
            empMapper.deleteByDeptId(id);
        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setLog("执行了解散部门的操作，本次解散的是 "+id+" 号部门");
            deptLogService.insert(deptLog);
        }
        return row;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int add(Dept dept) {

        //将注册时间与修改时间填写为当前时间
        int row;
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        row = deptMapper.insert(dept);

        return row;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int update(Dept dept) {

        int row;
        dept.setCreateTime(LocalDateTime.now());
        row = deptMapper.updateById(dept);

        return row;
    }

    @Override
    public Dept get(Integer id) {

        Dept dept = deptMapper.get(id);

        return dept;
    }
}
