package com.itheima.tliasweb.service.impl;

import com.itheima.tliasweb.mapper.EmpLogMapper;
import com.itheima.tliasweb.pojo.EmpLog;
import com.itheima.tliasweb.service.EmpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpLogServiceImpl implements EmpLogService {

    @Autowired
    private EmpLogMapper empLogMapper;
   //Propagation.REQUIRES_NEW ：需要新开启一个事务
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insertLog(EmpLog empLog) {
        empLogMapper.insert(empLog);
    }
}
