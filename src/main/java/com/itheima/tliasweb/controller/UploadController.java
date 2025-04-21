package com.itheima.tliasweb.controller;

import com.itheima.tliasweb.pojo.Result;
import com.itheima.tliasweb.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Slf4j
@Controller
public class UploadController {
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;
    /*
    本地磁盘储存方案
     */
//    @PostMapping("/upload")
//    public Result upload(String name, Integer age, MultipartFile file) throws IOException {
//        log.info("文件上传：{},{},{}", name, age, file.getOriginalFilename());
//        // 获取上传文件后缀名
//        String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
//        String filename = UUID.randomUUID().toString()+extension;
//        // 文件上传到本地
//        file.transferTo(new java.io.File("D:/images/" + filename));
//        return Result.success();
//    }
   @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
       log.info("文件上传：{}", file.getOriginalFilename());
       //将文件加入阿里云oss
       String url =  aliyunOSSOperator.upload(file.getBytes(),file.getOriginalFilename());
       log.info("文件上传成功d url{}",url);
       return Result.success(url);
   }
}
