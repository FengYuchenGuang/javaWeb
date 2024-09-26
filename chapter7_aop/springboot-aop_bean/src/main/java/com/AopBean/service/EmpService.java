package com.AopBean.service;



import com.AopBean.pojo.Emp;
import com.AopBean.pojo.PageBean;
import java.time.LocalDate;
import java.util.List;

/**
 * @author hxz
 */
public interface EmpService {

    /**
     * 查询全部 emp表 中员工记录
     * @return
     */
    List<Emp> list();

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    List<Emp> page(Integer page, Integer pageSize);

    /**
     * 条件查询
     * @return
     */
    List<Emp> query(String name, Short gender, LocalDate start, LocalDate end);

    /**
     * 批量删除
     * @param ids
     */
    int deletes(List<Integer> ids);


    /**
     * 添加员工
     *
     */
    int add(Emp emp);


    /**
     * ========= tlias =============
     */

    PageBean page_tlias(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);


    /**
     * 添加员工
     * @param emp
     * @return
     */
    int insert_tlias(Emp emp);


    /**
     * 批量删除
     * @param ids
     */
    int delete_tlias(List<Integer> ids);

    /**
     * 根据ID查询员工
     * @param id
     * @return
     */
    Emp getById_tlias(Integer id);

    /**
     * 更新员工
     * @param emp
     */
    int update_tlias(Emp emp);


    /**
     * 登录验证，查找数据库中是否有 该用户
     * 有 返回 Emp
     * 没有返回 null
     */
    Emp login(Emp emp);

}
