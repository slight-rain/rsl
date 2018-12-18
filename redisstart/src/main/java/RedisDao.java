import com.redis.utils.PropertyUtil;
import redis.clients.jedis.Jedis;
public class RedisDao{

    private Jedis jedis;
    public RedisDao(){
        jedis=new Jedis(PropertyUtil.getProperty("redis.host"),Integer.valueOf(PropertyUtil.getProperty("redis.port")));
    }

    public Jedis getJedis() {
        return jedis;
    }

    public void setJedis(Jedis jedis) {
        this.jedis = jedis;
    }
    public void setdata(String key,String value){
        jedis.set(key,value);
    }
    public String getdata(String key){
        return jedis.get(key);
    }
}
