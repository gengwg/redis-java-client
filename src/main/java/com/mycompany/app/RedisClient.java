package com.mycompany.app;

import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;


public class RedisClient {
	private static final int TIMEOUT = 2000;
	private static final int SOTIMEOUT = 2000;
	private static final String PASSWD = "77a46C9CeXZvV9nFCqkEKbMcmuy2MCVq";
	private static final int MAX_REDIRECTIONS = 32;

	public static void main(String[] args) {
		initializeJedisCluster();
	}

	private static void initializeJedisCluster(){

		// GenericObjectPoolConfig config = new GenericObjectPoolConfig();
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(100);
		config.setJmxEnabled(false);
		config.setMaxWaitMillis(2000);
		Set<HostAndPort> jedisClusterNode = new HashSet<HostAndPort>();
		jedisClusterNode.add(new HostAndPort("192.168.33.10", 7379));
		jedisClusterNode.add(new HostAndPort("192.168.33.10", 7479));
		jedisClusterNode.add(new HostAndPort("192.168.33.10", 7579));
		jedisClusterNode.add(new HostAndPort("192.168.33.10", 7679));
		jedisClusterNode.add(new HostAndPort("192.168.33.10", 7779));
		jedisClusterNode.add(new HostAndPort("192.168.33.10", 7879));
		
		//JedisCluster jc=new JedisCluster(jedisClusterNode);

		// without password
		JedisCluster jc = new JedisCluster(jedisClusterNode, TIMEOUT, MAX_REDIRECTIONS, config);

		// with password
		// JedisCluster jc = new JedisCluster(jedisClusterNode, TIMEOUT, SOTIMEOUT, MAX_REDIRECTIONS, PASSWD, config);
		
		System.out.println("Connection to server sucessfully");
		
		System.out.println("The number of nodes in cluster is: " + jc.getClusterNodes().size());
		jc.set("foo","bar");
		jc.set("hello","world");
		System.out.println("foo: " + jc.get("foo"));
		System.out.println("hello: " + jc.get("hello"));

		//check whether server is running or not
		//System.out.println("Server is running: "+jc.ping());
   }
}