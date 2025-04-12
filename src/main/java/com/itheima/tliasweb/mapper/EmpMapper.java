package com.itheima.tliasweb.mapper;

import com.itheima.tliasweb.pojo.Emp;
import com.itheima.tliasweb.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface EmpMapper {
//    ——————————————————————————原始分页查询——————————————————————————
//    /**
//     * 查询总数
//     * @return
//     */
//    @Select("select count(*) from emp left join tlias.emp_expr ee on emp.id = ee.emp_id")
//    public Long count();
//    /**
//     * 分页查询
//     * @return
//     */
//    @Select("select * from emp left join tlias.emp_expr ee " +
//            "on emp.id = ee.emp_id ORDER BY emp.update_time desc limit #{start},#{pageSize}")
//    public List<Emp> list(Integer start, Integer pageSize);
//    @Select("select * from emp left join tlias.emp_expr ee " +
//            "on emp.id = ee.emp_id ORDER BY emp.update_time desc ")


    //    public List<Emp> list(String name, Integer gender, LocalDate begin, LocalDate end);
    public List<Emp> list(EmpQueryParam empQueryParam);
//新增员工
    @Insert("insert into emp(username,password,name,gender,phone,job,salary,image,entry_date,dept_id,create_time,update_time) "+
    "values(#{username},#{password},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{createTime},#{updateTime})")
     void insert(Emp emp);
}
