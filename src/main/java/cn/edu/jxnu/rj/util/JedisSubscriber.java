package cn.edu.jxnu.rj.util;

import cn.edu.jxnu.rj.domain.ChatMessage;
import redis.clients.jedis.JedisPubSub;

import javax.websocket.EncodeException;
import javax.websocket.Session;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JedisSubscriber extends JedisPubSub {
    private Session session;

    public JedisSubscriber(Session session) {
        this.session = session;
    }

    @Override
    public void onMessage(String channel, String message) {
        System.out.println(channel+":"+message);
        try {
            this.session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.println("订阅了"+channel);
    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        System.out.println("取消订阅"+channel);
    }
}
