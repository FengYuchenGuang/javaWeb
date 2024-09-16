package hxz.pro.tlias.service.impl;

import hxz.pro.tlias.mapper.EmpMapper;
import hxz.pro.tlias.pojo.Emp;
import hxz.pro.tlias.pojo.PageBean;
import hxz.pro.tlias.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * @author hxz
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Emp> list() {

        List<Emp> empList = empMapper.list();
        return empList;
    }

    @Override
    public List<Emp> page(Integer page, Integer pageSize) {

        List<Emp> empList = empMapper.page(page,pageSize);
        return empList;
    }

    @Override
    public List<Emp> query(String name, Short gender, LocalDate start, LocalDate end) {

        List<Emp> empList = empMapper.query(name,gender,start,end);
        return empList;
    }

    @Override
    public int deletes(List<Integer> ids) {
        int row = empMapper.deletes(ids);
        return row;
    }

    @Override
    public int add(Emp emp) {

        int row = empMapper.insert(emp);
        return row;
    }

}
