package hxz.pro.tlias.mapper;

import hxz.pro.tlias.pojo.Emp;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * @author hxz
 * 员工管理
 */
@Repository
@Mapper
public interface EmpMapper {

    /**
     * 查询总记录数
     * @return
     */
    @Select("select count(*) from emp")
    public Long count();

    /**
     * 分页查询,获取列表数据
     * @param start
     * @param pageSize
     * @return
     */
    @Select("select * from emp limit #{page},#{pageSize}")
    public List<Emp> page(@Param("page") Integer start, @Param("pageSize") Integer pageSize);

    /**
     * 员工信息查询
     * @return
     */
    //@Select("select * from emp")
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 批量删除
     * @param ids
     */
    int deletes(@Param("ids") List<Integer> ids);

    /**
     * 单个删除测试
     */
    @Delete("delete from emp where id = #{id}")
    public int delete(Integer id);


    /**
     * 添加员工
     */
    //新增员工
    @Options(useGeneratedKeys = true, keyProperty = "id") //主键返回
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},now(),now())")
    int insert(Emp emp);
}
