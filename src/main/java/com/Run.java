package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.mp.dao")
public class Run {

    public static void main(String[] args) {
        SpringApplication.run(Run.class, args);
    }

}
