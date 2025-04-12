package com.itheima.tliasweb.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class EmpQueryParam {
    private Integer page=1;// 当前页码
    private Integer pageSize=10;// 每页显示条数
    private String name;// 员工姓名
    private Integer gender;// 员工性别
    @DateTimeFormat(pattern = "yyyy-MM-dd")// 指定日期格式
    private LocalDate begin;// 入职日期范围-开始
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;// 入职日期范围-结束
}
