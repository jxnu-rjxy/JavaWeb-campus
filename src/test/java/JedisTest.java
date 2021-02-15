import cn.edu.jxnu.rj.service.FriendService;
import cn.edu.jxnu.rj.service.Impl.FriendServiceImpl;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

public class JedisTest {
    @Test
    public void connetc(){
        Jedis jedis = new Jedis("118.31.173.242",6379);
        jedis.publish("MatchChat","aaa");
        jedis.close();
        jedis.publish("MatchChat","bbb");
    }
}
