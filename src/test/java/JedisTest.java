import cn.edu.jxnu.rj.service.FriendService;
import cn.edu.jxnu.rj.service.Impl.FriendServiceImpl;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

public class JedisTest {
    @Test
    public void connetc(){
        Jedis jedis = new Jedis("118.31.173.242",6379);
        FriendService friendService = new FriendServiceImpl();
//        friendService.follow("2","4");
//        friendService.follow("2","7");
//        friendService.follow("2","8");
//        friendService.follow("2","9");
        friendService.follow("4","2");
        friendService.follow("7","2");
        friendService.follow("8","2");
        friendService.follow("9","2");

    }
}
