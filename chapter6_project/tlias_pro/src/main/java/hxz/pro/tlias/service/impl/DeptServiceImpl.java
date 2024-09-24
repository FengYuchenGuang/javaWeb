package hxz.pro.tlias.service.impl;

import hxz.pro.tlias.mapper.DeptMapper;
import hxz.pro.tlias.pojo.Dept;
import hxz.pro.tlias.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author hxz
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> list() {

        List<Dept> list = deptMapper.list();
        return list;
    }

    @Override
    public int delete(Integer id) {

        int row = deptMapper.deleteById(id);
        return row;
    }

    @Override
    public int add(Dept dept) {

        //将注册时间与修改时间填写为当前时间
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        int row = deptMapper.insert(dept);
        return row;
    }

    @Override
    public int update(Dept dept) {

        dept.setCreateTime(LocalDateTime.now());
        int row = deptMapper.updateById(dept);
        return row;
    }

    @Override
    public Dept get(Integer id) {

        Dept dept = deptMapper.get(id);

        return dept;
    }
}
