package hxz.pro.tlias.service;

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
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 批量删除
     * @param ids
     */
    void delete(List<Integer> ids);
}
