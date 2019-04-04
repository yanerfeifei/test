package com.redis;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * Created by meridian on 2018/9/21.
 */
public class TestRedis {
    private Jedis jedis;
    private String pre_str = "a:d";			//redis的key的前缀

    @Before
    public void setup() {
        System.out.println("---------------------------------setup------------------");
        // 连接redis服务器，127.0.0.1:6379
        jedis = new Jedis("10.1.1.19", 6379);
        // 权限认证
        jedis.auth("WudiHX0Q3A98eVqy");
    }

    /**
     * redis批量删除以某字符串前缀的key
     */
    @Test
    public void testBatchDel() {
        System.out.println("---------------------------------testBatchDel------------------");
        batchDel(jedis);
    }

    private void batchDel(Jedis jedis){
        Set<String> set = jedis.keys(pre_str +"*");
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            String keyStr = it.next();
            System.out.println(keyStr);
            jedis.del(keyStr);
        }
    }

}
