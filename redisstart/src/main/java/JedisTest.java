public class JedisTest {
    public static void main(String[] args) {
        RedisDao redisDao=new RedisDao();
        redisDao.setdata("123","456");
        System.out.println(redisDao.getdata("123"));
    }
}
