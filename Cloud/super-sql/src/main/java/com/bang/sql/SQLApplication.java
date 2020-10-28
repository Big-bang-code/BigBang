package com.bang.sql;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling//定时任务的注解
public class SQLApplication implements ApplicationListener<DataSourceInitializedEvent> {

    public static void main(String[] args){
        SpringApplication.run(SQLApplication.class,args);
    }


    @Override
    public void onApplicationEvent(DataSourceInitializedEvent event) {

    }
}
