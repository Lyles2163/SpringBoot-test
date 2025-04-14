package com.itheima.tliasweb.controller;

import com.itheima.tliasweb.pojo.Emp;
import com.itheima.tliasweb.pojo.PageResult;
import com.itheima.tliasweb.pojo.Result;
import com.itheima.tliasweb.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/emp")
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize){
        log.info("分页查询，当前页码{},每页记录数{}",page,pageSize);
        PageResult<Emp> pageResult= empService.page(page,pageSize);
        return Result.success(pageResult);
    }
}

