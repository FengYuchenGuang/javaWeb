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
    int delete(Integer id);

    /**
     * 新增部门
     * @param dept
     */
    int add(Dept dept);


    /**
     * 修改部门
     * @param dept
     * @return
     */
    int update(Dept dept);


    /**
     * 获取单个部门信息
     * @param id
     * @return
     */
    Dept get(Integer id);
}
