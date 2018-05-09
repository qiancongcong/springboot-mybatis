package cc;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.util.HashSet;

/**
 * @Author: cc
 * @Date: Created in 16:48 2018/1/10
 */
public class testJedis {

    @Test
    public void testJedis(){
        //创建一个jedis对象
        Jedis jedis = new Jedis("192.168.101.128",6379);
        //调用Jedis对象方法，方法名称和reids的命令一样
        jedis.set("cc","Jedis test");
        String cc = jedis.get("cc");
        System.out.println(cc);
        //关闭链接
        jedis.close();

    }

    /**
     * jedis连接池
     */
    @Test
    public void testJedisPool(){
        JedisPool jedisPool = new JedisPool("192.168.101.128",6379);
        //从连接池中获得jedis对象
        Jedis jedis= jedisPool.getResource();
        String cc = jedis.get("cc");
        System.out.println(cc);
        jedis.close();
        jedisPool.close();
    }

    /**
     * 集群测试
     */
    @Test
    public void testJedisCluster() {
        HashSet<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("192.168.25.153", 7001));
        nodes.add(new HostAndPort("192.168.25.153", 7002));
        nodes.add(new HostAndPort("192.168.25.153", 7003));
        nodes.add(new HostAndPort("192.168.25.153", 7004));
        nodes.add(new HostAndPort("192.168.25.153", 7005));
        nodes.add(new HostAndPort("192.168.25.153", 7006));

        JedisCluster cluster = new JedisCluster(nodes);

        cluster.set("key1", "1000");
        String string = cluster.get("key1");
        System.out.println(string);
        try {
            cluster.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
