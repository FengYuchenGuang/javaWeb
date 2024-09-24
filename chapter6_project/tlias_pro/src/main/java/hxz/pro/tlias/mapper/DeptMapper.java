package hxz.pro.tlias.mapper;

import hxz.pro.tlias.pojo.Dept;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hxz
 */
@Repository
@Mapper
public interface DeptMapper {
    /**
     * 查询全部部门
     * @return
     */
    @Select("select * from dept")
    List<Dept> list();

    /**
     * 根据ID删除部门
     * @param id
     */
    @Delete("delete from dept where id = #{id}")
    int deleteById(Integer id);

    /**
     * 新增部门
     * @param dept
     */
    @Options(useGeneratedKeys = true, keyProperty = "id") //主键返回
    @Insert("insert into dept(name, create_time, update_time) values(#{name}, #{createTime}, #{updateTime})")
    int insert(Dept dept);

    /**
     * 修改部门
     * @param dept
     * @return
     */
    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    int updateById(Dept dept);

    /**
     * 获取单个部门信息
     * @param id
     * @return
     */
    @Select("select * from dept where id = #{id}")
    Dept get(Integer id);
}
