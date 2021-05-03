package com.kuang.dao;

import com.kuang.pojo.SysLog;

import java.util.List;

/**
 * 日志相关查询
 */
public interface SysMapper {
    public void save(SysLog sysLog) throws Exception;

   public List<SysLog> findAll() throws Exception;

    public List<SysLog> queryForUserName(String userName);

    void deleteAllSysLog();
}
