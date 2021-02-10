import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

public class JedisTest {
    @Test
    public void connetc(){
        Jedis jedis = new Jedis("118.31.173.242",6379);
        System.out.println(jedis.ping());
        Subscriber subscriber = new Subscriber();
        jedis.subscribe(subscriber,"channel1");
//        jedis.publish("channel1","这是来自IDEA");
    }
}
