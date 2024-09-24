package hxz.pro.tlias.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import hxz.pro.tlias.mapper.EmpMapper;
import hxz.pro.tlias.pojo.Emp;
import hxz.pro.tlias.pojo.PageBean;
import hxz.pro.tlias.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    /**
     * 分页查询,获取列表数据
     *
     * select * from emp limit 起始索引,每页记录数
     * 其实索引从0开始 起始索引 = （查询页码 - 1）*（每页记录数）
     */
    @Override
    public List<Emp> page(Integer page, Integer pageSize) {

        Integer start = (page-1)*pageSize;
        List<Emp> empList = empMapper.page(start,pageSize);
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




    /**
     * =============================
     * ========= tlias =============
     * =============================
     */


    /**
     * 页数要在 总记录数与每页个数 限制下 的页数范围内
     * 这方面的限制是在 前端页面中完成
     * 即 每次打开页面 先加载默认的 第一页，然后 前端跳转页面文本框 中 填入数字大于最大页数，则被设置为 最大页数
     * 因此后端不用 判断页数是否超出
     * @param page
     * @param pageSize
     * @param name
     * @param gender
     * @param begin
     * @param end
     * @return
     */
//    @Override
//    public PageBean page_tlias(Integer page, Integer pageSize,String name,Short gender,LocalDate begin,LocalDate end) {
//
//
//        Long count = empMapper.count();
//        Integer start = (page-1)*pageSize;
//        List<Emp> empList = empMapper.page(start,pageSize);
//
//        PageBean pageBean = new PageBean(count,empList);
//        return pageBean;
//    }

    @Override
    public PageBean page_tlias(Integer page, Integer pageSize,String name,Short gender,LocalDate begin,LocalDate end) {
        //1. 设置分页参数
        PageHelper.startPage(page,pageSize);

        //2. 执行查询
        List<Emp> empList = empMapper.query(name,gender,begin,end);
        Page<Emp> p = (Page<Emp>) empList;

        //3. 封装PageBean对象
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;

    }

    @Override
    public int insert_tlias(Emp emp) {

        int row = empMapper.insert(emp);
        return row;
    }

    @Override
    public int delete_tlias(List<Integer> ids) {

        int row;
        row = empMapper.deletes(ids);
        return row;
    }


    @Override
    public Emp getById_tlias(Integer id) {
        return empMapper.getById_tlias(id);
    }

    @Override
    public int update_tlias(Emp emp) {

        int row;
        emp.setUpdateTime(LocalDateTime.now());
        row = empMapper.update_tlias(emp);
        return row;


    }

}
