package hxz.pro.tlias.mapper;

import hxz.pro.tlias.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
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
    void deleteById(Integer id);

    /**
     * 新增部门
     * @param dept
     */
    @Insert("insert into dept(name, create_time, update_time) values(#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);
}
