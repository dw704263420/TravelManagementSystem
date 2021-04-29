package com.kuang.service;

import com.kuang.pojo.SysLog;

import java.util.List;

public interface  SysService {
    public void save(SysLog sysLog) throws Exception;

    List<SysLog> findAll(int page,int size) throws Exception;
}
