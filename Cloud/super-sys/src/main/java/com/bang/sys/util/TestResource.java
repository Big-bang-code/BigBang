package com.bang.sys.util;


import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

@Order(value = 1)//如果是多个的话，可以指定value来确认执行的顺序
public class TestResource implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("启动后跟随加载数据");

        System.out.println("加载数据完成");
    }
}
