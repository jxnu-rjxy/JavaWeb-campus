package cn.edu.jxnu.rj.websocket;

import cn.edu.jxnu.rj.domain.ChatMessage;
import cn.edu.jxnu.rj.util.JedisSubThread;
import cn.edu.jxnu.rj.util.JedisSubscriber;
import com.google.gson.Gson;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisPubSub;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/websocket")
public class MatchChat {
    private Session session;
    private JedisPool jedisPool;
    private JedisPoolConfig config = new JedisPoolConfig();
    private final String redisIp = "118.31.173.242";
    private final int redisPort = 6379;
    @OnOpen
    public void onOpen(Session session){
        this.session = session;

        this.jedisPool = new JedisPool(new JedisPoolConfig(),this.redisIp,this.redisPort);

        JedisSubThread jedisSubThread = new JedisSubThread(this.jedisPool,this.session);
        jedisSubThread.start();

        System.out.println("websocket建立连接！");
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("来自客户端的消息"+message);
        Jedis jedis = null;
        try{
            jedis = this.jedisPool.getResource();
            jedis.publish("MatchChat",message);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (jedis!=null)
                jedis.close();
        }
    }

    @OnClose
    public void onClose(Session session){
        System.out.println("websocket关闭连接");

    }

    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("websocket出错！：");
        error.printStackTrace();
    }

}
