package com.itheima.tliasweb.mapper;

import com.itheima.tliasweb.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
    @Select("select * from emp left join tlias.emp_expr ee " +
            "on emp.id = ee.emp_id ORDER BY emp.update_time desc ")
    public List<Emp> list();

}
