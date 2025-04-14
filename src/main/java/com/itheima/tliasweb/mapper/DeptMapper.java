package com.itheima.tliasweb.mapper;

import com.itheima.tliasweb.pojo.Dept;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     *
     * 手动映射列名
     */
    @Results({
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "update_time",property = "updateTime"),
    })
    //起别名
    @Select("select id,name,create_time,update_time from dept")
//    @Select("select * from dept")
    List<Dept> findAll();
    @Insert("insert into dept(name,create_time,update_time) values(#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);
   @Delete("delete from dept where id=#{id}")
    void deleteById(Integer id);
   @Select("select id,name,create_time,update_time from dept where id=#{id}" )
    Dept getById(Integer id);
    @Update("update dept set name=#{name} ,update_time=#{updateTime} where id=#{id}" )
    void update(Dept dept);
}
