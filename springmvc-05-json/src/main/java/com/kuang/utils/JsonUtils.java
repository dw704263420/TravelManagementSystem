package com.kuang.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonUtils {
    // 重载 不使用时间格式 但还是套娃
    public  static String getJson(Object object) throws JsonProcessingException {
        return getJson(object,"yyyy-MM-dd HH:mm:ss");

    }



    public  static String getJson(Object object,String format) throws JsonProcessingException {
       ObjectMapper mapper = new ObjectMapper();


        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(format);

        mapper.setDateFormat(sdf);

        return mapper.writeValueAsString(object);

    }
}
