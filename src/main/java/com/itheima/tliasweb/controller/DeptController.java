package com.itheima.tliasweb.controller;

import com.itheima.tliasweb.pojo.Dept;
import com.itheima.tliasweb.pojo.Result;
import com.itheima.tliasweb.service.DeptService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    //    @RequestMapping(value = "/dept",method = RequestMethod.GET)
//    @PostMapping("/dept")
    @GetMapping
    public Result list() {
        log.info("查询所有信息");
        System.out.println("查询所有信息");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);

    }

    //    @DeleteMapping("/depts/{id}")
//    public Result delete(@PathVariable Integer id){
//        System.out.println("根据id部门删除："+id);
//        return Result.success();
//    }
//    @DeleteMapping("/depts")
//    public Result delete(@RequestParam("id" ) Integer deptId){
//
//        System.out.println("根据id部门删除："+deptId);
//        return Result.success();
//    }
    @DeleteMapping
    public Result delete( Integer id){
//        System.out.println("根据id部门删除："+id);
        log.info("根据id部门删除：{}",id);
        deptService.delete(id);
        return Result.success();
    }
    @PostMapping
    public Result save(@RequestBody Dept dept) {
//        System.out.println("新增部门：" + dept);
        log.info("新增部门：{}",dept);
        deptService.add(dept);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer deptId) {
//        System.out.println("根据deptId查询部门：" + deptId);
        log.info("根据deptId查询部门：{}",deptId);
        Dept dept = deptService.getById(deptId);
        return Result.success();
    }
    @PutMapping
    public Result update(@RequestBody Dept dept) {
//        System.out.println("修改部门：" + dept);
        log.info("修改部门：{}",dept);
        deptService.update(dept);
        return Result.success();
    }
}
