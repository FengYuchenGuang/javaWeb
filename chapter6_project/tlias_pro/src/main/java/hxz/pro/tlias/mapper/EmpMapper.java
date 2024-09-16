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
     * 员工信息查询
     * @return
     */
    @Select("select * from emp")
    public List<Emp> list();


    /**
     * 分页查询,获取列表数据
     *
     * select * from emp limit 起始索引,每页记录数
     * 其实索引从0开始 起始索引 = （查询页码 - 1）*（每页记录数）
     *
     * @param start
     * @param pageSize
     * @return
     */
    @Select("select * from emp limit #{page},#{pageSize}")
    public List<Emp> page(@Param("page") Integer start, @Param("pageSize") Integer pageSize);


    /**
     * 条件查询
     *
     * 动态条件查询
     *  对于mapper接口中，传入的参数有多个时必须使用 @param 进行标识
     */
    List<Emp> query(@Param("name") String name,
                    @Param("gender") Short gender,
                    @Param("begin") LocalDate start,
                    @Param("end") LocalDate end);


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
     *
     * 两个时间可以不用 now() 在添加数据库时设置当前时间
     * 也可以在 service层 中将 createTime 与 updateTime
     * 设置为当前时间 用  setCreateTime(LocalDateTime.now());
     *                 setUpdateTime(LocalDateTime.now());
     */
    //新增员工
    @Options(useGeneratedKeys = true, keyProperty = "id") //主键返回
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},now(),now())")
    int insert(Emp emp);
}
