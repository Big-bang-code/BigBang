package com.bang.utils.redis;

import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 初始化JedisPool 配置参数，从JedisPool 中取得Jedis。
 * Jedis是Redis首选的Java客户端开发包
 */
public class RedisUtil {

    //jedispool,需要JedisPoolConfig
    private JedisPool jedisPool;

    //初始化
    public void initJedisPool(String host, int port, int database, String password){
        //设置一些初始化参数
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //总数
        jedisPoolConfig.setMaxTotal(200);
        //获取连接时等待的最大毫秒
        jedisPoolConfig.setMaxTotal(10*1000);
        //最少剩余数
        jedisPoolConfig.setMinIdle(10);
        //如果到最大数，设置等待
        jedisPoolConfig.setBlockWhenExhausted(true);
        //等待时间
        jedisPoolConfig.setTestWhileIdle(true);
        //在获取连接时，检查是否有效
        jedisPoolConfig.setTestOnBorrow(true);

        //初始化jedisPool
        if (StringUtils.isNotEmpty(password)){
            jedisPool = new JedisPool(jedisPoolConfig,host,port,20*1000,password);
        }else{
            jedisPool = new JedisPool(jedisPoolConfig,host,port,20*1000);
        }
    }

    //获取jedis
    public Jedis getJedis(){
        Jedis jedis = jedisPool.getResource();
        return jedis;
    }
}
