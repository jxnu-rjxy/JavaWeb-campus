package cn.edu.jxnu.rj.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.websocket.Session;

public class JedisSubThread extends Thread{
    private final JedisPool jedisPool;
    private final JedisSubscriber jedisSubscriber;
    private final String channel = "MatchChat";

    public JedisSubThread(JedisPool jedisPool, Session session) {
        this.jedisSubscriber = new JedisSubscriber(session);
        this.jedisPool = jedisPool;
    }

    @Override
    public void run() {
        Jedis jedis = null;
        try {
            jedis = this.jedisPool.getResource();
            jedis.subscribe(this.jedisSubscriber,this.channel);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(null != jedis)
                jedis.close();
        }
    }
}
