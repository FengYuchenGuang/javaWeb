package hxz.pro.tlias.service;

import hxz.pro.tlias.pojo.Emp;
import hxz.pro.tlias.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * @author hxz
 */
public interface EmpService {
    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    List<Emp> page(Integer page, Integer pageSize);

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

}
