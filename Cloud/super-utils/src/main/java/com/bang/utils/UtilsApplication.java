package com.bang.utils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class UtilsApplication {

    public static void main(String[] args) {
        SpringApplication.run(UtilsApplication.class,args);
    }

}
