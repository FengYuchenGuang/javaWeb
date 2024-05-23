package hxz.pro.tlias.mapper;

import hxz.pro.tlias.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
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
    @Select("select * from emp limit #{start},#{pageSize}")
    public List<Emp> page(Integer start, Integer pageSize);

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
    void deletes(List<Integer> ids);

    /**
     * 单个删除测试
     */
    @Delete("delete from emp where id = #{id}")
    public void delete(Integer id);
}
