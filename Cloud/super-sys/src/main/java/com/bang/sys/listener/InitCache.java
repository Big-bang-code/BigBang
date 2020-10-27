package com.bang.sys.listener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

/**
 * 初始化缓存：如用户、数据字典等
 */
@Order(value = 2)
public class InitCache implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("执行value为2");
    }

}
