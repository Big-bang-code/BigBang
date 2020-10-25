package com.bang.sys;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SysAppliaction {

    public static void main(String[] args) {
        SpringApplication.run(SysAppliaction.class,args);
    }
}
