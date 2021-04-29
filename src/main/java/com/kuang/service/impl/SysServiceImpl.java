package com.kuang.service.impl;

import com.github.pagehelper.PageHelper;
import com.kuang.dao.SysMapper;
import com.kuang.pojo.SysLog;
import com.kuang.service.SysService;

import java.util.List;

public class SysServiceImpl implements SysService {
    private SysMapper sysMapper;

    public void setSysMapper(SysMapper sysMapper) {
        this.sysMapper = sysMapper;
    }

    @Override
    public void save(SysLog sysLog) throws Exception {
        sysMapper.save(sysLog);
    }

    @Override
    public List<SysLog> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        return sysMapper.findAll();
    }
}
