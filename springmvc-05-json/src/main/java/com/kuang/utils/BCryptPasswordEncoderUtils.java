package com.kuang.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {
    // 这里主要是做一个测试方法用
    @Autowired


    public  static  BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
    public static String emcodePassword(String password)
    {
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String test =BCryptPasswordEncoderUtils.emcodePassword("123");
        boolean matches = bCryptPasswordEncoder.matches("123", "$2a$10$nKX0ucTQ.igLMt4qui7lDeZQZdCZlH5VjgO2zKLt4NsnY/kWSoLVy");
        System.out.println(matches);
        System.out.println(test);//$2a$10$ax1DLH/QUG7IUWg.Lz9WQ.8nMw.xCJcnJniaeotjDwI62ymLZiiju  每次加密是不太一样的，可以更加安全
    }
}
