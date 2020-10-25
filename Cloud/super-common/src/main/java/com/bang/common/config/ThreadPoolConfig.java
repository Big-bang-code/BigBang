package com.bang.common.config;


import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 固定数量的线程池
 */
@Component
public class ThreadPoolConfig {

    public static ExecutorService cachedThreadPool = Executors.newFixedThreadPool(50);


    /**
     * 返回线程池
     * @return
     */
    public ExecutorService getThreadPool(){
        return cachedThreadPool;
    }
}
