package com.kuang.pojo;

import com.kuang.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 日志类
 */
public class SysLog {
    private String id;
    @DateTimeFormat(pattern = "yyyy-MM-dd Hh:mm:ss")
    private Date visitTime;
    private String visitTimeStr;
    private String username;
    private String ip;  // 来自ip
    private String url;  // 访问资源
    private Long executionTime; // 执行时间
    private String method;  // 调用方法名

    public SysLog() {
    }

    public SysLog(String id, Date visitTime, String visitTimeStr, String username, String ip, String url, Long executionTime, String method) {
        this.id = id;
        this.visitTime = visitTime;
        this.visitTimeStr = visitTimeStr;
        this.username = username;
        this.ip = ip;
        this.url = url;
        this.executionTime = executionTime;
        this.method = method;
    }

    public String getVisitTimeStr() {
        if (visitTime!=null)
        {
            visitTimeStr = DateUtils.date2String(visitTime,"yyyy-MM-dd HH:mm");
        }
        return visitTimeStr;
    }

    public void setVisitTimeStr(String visitTimeStr) {

        this.visitTimeStr = visitTimeStr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Long executionTime) {
        this.executionTime = executionTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
