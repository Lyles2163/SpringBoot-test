package com.itheima.tliasweb.controller;

import com.itheima.tliasweb.pojo.Emp;
import com.itheima.tliasweb.pojo.EmpQueryParam;
import com.itheima.tliasweb.pojo.PageResult;
import com.itheima.tliasweb.pojo.Result;
import com.itheima.tliasweb.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;
//    @GetMapping
//    public Result page(@RequestParam(defaultValue = "1") Integer page,
//                       @RequestParam(defaultValue = "10") Integer pageSize,
//                       String name, Integer gender,
//                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
//                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end ){
//        log.info("分页查询，当前页码{},每页记录数{},{},{},{},{}",page,pageSize,name,gender,begin,end);
//        PageResult<Emp> pageResult= empService.page(page,pageSize,name,gender,begin,end);
//        return Result.success(pageResult);
//    }


        @GetMapping
    public Result page(EmpQueryParam empQueryParam){
        log.info("分页查询{}",empQueryParam);
        PageResult<Emp> pageResult= empService.page(empQueryParam);
        return Result.success(pageResult);
    }
@PostMapping
    public  Result save(@RequestBody Emp emp){
        log.info("新增员工{}",emp);
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empService.save(emp);
        return Result.success();
    }
}

