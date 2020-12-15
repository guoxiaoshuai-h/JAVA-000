package com.marcus.ss.ssdemo;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
public class SsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsDemoApplication.class, args);
    }

}
