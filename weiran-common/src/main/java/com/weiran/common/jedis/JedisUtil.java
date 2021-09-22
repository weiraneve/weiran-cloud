package com.weiran.common.jedis;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

/**
 * redicache 工具类
 *
 */
@Service
public class JedisUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    private static JedisPool jedisPool = null;

    public JedisUtil(){}

    public static JedisPool getJedisPool(){
        if (jedisPool ==null){
            synchronized (JedisPool.class){
                if (jedisPool==null){
                    jedisPool = applicationContext.getBean(JedisPool.class);
                }
            }
        }
        return jedisPool;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(JedisUtil.applicationContext == null){
            JedisUtil.applicationContext  = applicationContext; //初始化 spring applicationContext
        }
    }

    /**
     * 根据key查看是否存在
     * @param key
     * @return
     */
    public static boolean hasKey(String key){
        Jedis jedis = getJedisPool().getResource();
        try{
            return jedis.exists(key);
        } finally {
            jedis.close();
        }
    }

    /**
     * 设置key -value 形式数据
     * @param key
     * @param value
     * @return
     */
    public static String set(String key,String value){
        Jedis jedis = getJedisPool().getResource();
        try{
            return jedis.set(key,value);
        } finally {
            jedis.close();
        }
    }

    /**
     * 设置 一个过期时间
     * @param key
     * @param value
     * @param timeOut 单位秒
     * @return
     */
    public static String set(String key,String value,int timeOut){
        Jedis jedis = getJedisPool().getResource();
        try {
            return jedis.setex(key,timeOut,value);
        } finally {
            jedis.close();
        }
    }

    /**
     * 『SET if Not eXists』(如果不存在，则 SET)的简写
     *
     * 将 key 的值设为 value ，当且仅当 key 不存在。
     * 若给定的 key 已经存在，则 SETNX 不做任何动作。
     * @param key
     * @param value
     * @return 设置成功，返回 1 ;设置失败，返回 0 。
     */
    public static boolean setNX(String key, String value) {
        Jedis jedis = getJedisPool().getResource();
        try {
            long result = jedis.setnx(key, value);
            return result == 1;
        } finally {
            jedis.close();
        }
    }

    /**
     * 给定 key 的值设为 value ，并返回 key 的旧值(old value)
     *
     * @param key
     * @param value
     * @return 返回给定 key 的旧值。当 key 没有旧值时，也即是， key 不存在时，返回 nil.
     */
    public static String getSet(String key, String value) {
        Jedis jedis = getJedisPool().getResource();
        try {
            return jedis.getSet(key, value);
        } finally {
            jedis.close();
        }
    }

    /**
     * 根据key获取value
     * @param key
     * @return
     */
    public static String getByKey(String key){
        Jedis jedis = getJedisPool().getResource();
        try {
            return jedis.get(key);
        } finally {
            jedis.close();
        }
    }

    /**
     * 根据通配符获取所有匹配的key
     * @param pattern
     * @return
     */
    public static Set<String> getKesByPattern(String pattern){
        Jedis jedis = getJedisPool().getResource();
        try {
            return jedis.keys(pattern);
        } finally {
            jedis.close();
        }
    }

    /**
     * 根据key删除
     * @param key
     */
    public static void delByKey(String key){
        Jedis jedis = getJedisPool().getResource();
        try {
            jedis.del(key);
        } finally {
            jedis.close();
        }
    }

    /**
     * 根据key获取过期时间
     * @param key
     * @return
     */
    public static long getTimeOutByKey(String key){
        Jedis jedis = getJedisPool().getResource();
        try {
            return jedis.ttl(key);
        } finally {
            jedis.close();
        }
    }

    /**
     * 清空数据 【慎用啊！】
     */
    public static void flushDB(){
        Jedis jedis = getJedisPool().getResource();
        try {
            jedis.flushDB();
        } finally {
            jedis.close();
        }
    }

    /**
     * 刷新过期时间
     * @param key
     * @param timeOut
     * @return
     */
    public static long refreshLiveTime(String key,int timeOut){
        Jedis jedis = getJedisPool().getResource();
        try {
            return jedis.expire(key,timeOut);
        } finally {
            jedis.close();
        }
    }
}
