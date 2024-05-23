package hxz.pro.tlias.service;

import hxz.pro.tlias.pojo.Dept;

import java.util.List;

/**
 * @author hxz
 */
public interface DeptService {
    /**
     * 查询全部部门数据
     * @return
     */
    List<Dept> list();

    /**
     * 删除部门
     * @param id
     */
    void delete(Integer id);

    /**
     * 新增部门
     * @param dept
     */
    void add(Dept dept);
}
