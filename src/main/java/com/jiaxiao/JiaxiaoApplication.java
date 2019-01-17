package com.jiaxiao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jiaxiao.dao")
public class JiaxiaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JiaxiaoApplication.class, args);
    }

}

