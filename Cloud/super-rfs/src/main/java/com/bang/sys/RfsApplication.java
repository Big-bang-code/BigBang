package com.bang.sys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = { "com.bang.common.**", "com.bang.rfs.**" })
public class RfsApplication {

    public static void main(String[] args) {
        SpringApplication.run(RfsApplication.class,args);
    }

}
