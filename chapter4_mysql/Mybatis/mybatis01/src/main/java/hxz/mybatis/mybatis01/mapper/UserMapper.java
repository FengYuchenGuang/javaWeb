package hxz.mybatis.mybatis01.mapper;

import hxz.mybatis.mybatis01.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hxz
 */
@Repository
@Mapper
public interface UserMapper {
    //查询全部用户信息
    @Select("select * from user")
    public List<User> list();
}
