package hxz.mybatis.mybatis02.mapper;

import hxz.mybatis.mybatis02.pojo.Emp;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * @author hxz
 */
@Mapper
@Repository
public interface EmpMapper {
    //根据ID删除数据
    @Delete("delete from emp where id = #{id}")
    public void delete(Integer id);
    //public int delete(Integer id); // int 影响行数


    //新增员工
    @Options(useGeneratedKeys = true, keyProperty = "id") //主键返回
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    public void insert(Emp emp);


    //更新员工
    @Update("update emp set username = #{username}, name = #{name}, gender = #{gender}, image = #{image}," +
            " job = #{job}, entrydate = #{entrydate}, dept_id = #{deptId},update_time = #{updateTime} where id = #{id}")
    public void update(Emp emp);


    //方案三: 开启mybatis的驼峰命名自动映射开关 --- a_cloumn ------> aColumn
    //根据ID查询员工
    @Select("select * from emp where id = #{id}")
    public Emp getById(Integer id);

    //方案一: 给字段起别名, 让别名与实体类属性一致
    //@Select("select id, username, password, name, gender, image, job, entrydate, " +
    //        "dept_id deptId, create_time createTime, update_time updateTime from emp where id = #{id}")
    //public Emp getById(Integer id);

    //方案二: 通过@Results, @Result注解手动映射封装
    //@Results({
    //        @Result(column = "dept_id", property = "deptId"),
    //        @Result(column = "create_time", property = "createTime"),
    //        @Result(column = "update_time", property = "updateTime")
    //})
    //@Select("select * from emp where id = #{id}")
    //public Emp getById(Integer id);



    //条件查询员工
    //方式一
    //@Select("select * from emp where name like '%${name}%' and gender = #{gender} and " +
    //        "entrydate between #{begin} and #{end} order by update_time desc ")
    //public List<Emp> list(String name, Short gender, LocalDate begin , LocalDate end);

    //方式二
//    @Select("select * from emp where name like concat('%',#{name},'%') and gender = #{gender} and " +
//            "entrydate between #{begin} and #{end} order by update_time desc ")
//    public List<Emp> list(String name, Short gender, LocalDate begin , LocalDate end);

    //动态条件查询
    //对于mapper接口中，传入的参数有多个时必须使用 @param 进行标识
    public List<Emp> list(@Param("name") String name,
                          @Param("gender")Short gender,
                          @Param("begin")LocalDate begin ,
                          @Param("end")LocalDate end);


    //动态更新员工
    public void update2(Emp emp);


    //批量删除员工
    public void deleteByIds(@Param("ids") List<Integer> ids);
}
