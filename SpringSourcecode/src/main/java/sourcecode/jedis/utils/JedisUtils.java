package sourcecode.jedis.utils;

import redis.clients.jedis.Jedis;

import java.util.Collections;

public class JedisUtils {

	private static Jedis jedis;
	/*
	 * static { jedis = new Jedis(); }
	 */

	/**
	 * 使用redis的set命令实现获取分布式锁
	 * 
	 * @param lockKey
	 *            可以就是锁
	 * @param requestId
	 *            请求ID，保证同一性
	 * @param expireTime
	 *            过期时间，避免死锁
	 * @return
	 */
	/*
	 * public static boolean getLock(String lockKey,String requestId,int expireTime)
	 * { //NX:保证互斥性 String result = jedis.set(lockKey, requestId, "NX", "EX",
	 * expireTime); if("OK".equals(result)) { return true; }
	 * 
	 * return false; }
	 */
	public static boolean getLock(String lockKey, String requestId, int expireTime) {
		Long result = jedis.setnx(lockKey, requestId);
		if (result == 1) {
			jedis.expire(lockKey, expireTime);
			return true;
		}

		return false;
	}

	/**
	 * 释放分布式锁
	 * 
	 * @param lockKey
	 * @param requestId
	 */
	public static boolean releaseLock(String lockKey, String requestId) {
		String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
		Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));

		if (result.equals(1L)) {
			return true;
		}
		return false;
	}
	/*
	 * public static void releaseLock(String lockKey,String requestId) { if
	 * (requestId.equals(jedis.get(lockKey))) { jedis.del(lockKey); } }
	 */
}
