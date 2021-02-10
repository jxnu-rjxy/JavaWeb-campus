import redis.clients.jedis.JedisPubSub;

public class Subscriber extends JedisPubSub {
    @Override
    public void onMessage(String channel, String message) {
        System.out.println("收到频道"+channel+"消息："+message);
        super.onMessage(channel, message);
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.println("订阅了"+channel);
        super.onSubscribe(channel, subscribedChannels);
    }


    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        System.out.println("退订频道+"+channel);
        super.onUnsubscribe(channel, subscribedChannels);
    }
}
