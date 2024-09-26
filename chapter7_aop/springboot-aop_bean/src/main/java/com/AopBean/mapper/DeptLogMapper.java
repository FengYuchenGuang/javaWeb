package com.AopBean.mapper;


import com.AopBean.pojo.DeptLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author hxz
 */
@Repository
@Mapper
public interface DeptLogMapper {

    /**
     * 记录日志
     */
    @Insert("insert into deptlog(create_time,log) values (#{createTime}, #{log})")
    void insert(DeptLog deptLog);
}
