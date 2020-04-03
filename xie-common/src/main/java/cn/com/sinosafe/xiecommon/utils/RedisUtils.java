package cn.com.sinosafe.xiecommon.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName:  RedisUtils
 * @Description:redis工具类
 * @author: xiehanchun
 * @date:   2020年2月6日 下午7:47:36
 * @Copyright:
 */
@SuppressWarnings({"rawtypes","unchecked"})
@Component
public class RedisUtils {
	public static final String REDIS_PRE = "cmis_agent_";
	@Autowired
	private RedisTemplate redisTemplate;

	/**
	 * 缓存key的生成策略：类名+方法名+参数
	 * @param dao 类的dao
	 * @param method
	 * @param params
	 * @return key
	 */
	public String generateKey(Object dao, String method, Object... params) {
		StringBuilder builder = new StringBuilder();
		builder.append(dao.getClass().getName());
		builder.append(method);
		if(params != null) {
			for(Object obj : params) {
				if(obj == null) {
					obj = "";
				}
				builder.append(obj.toString());
			}
		} else {
			builder.append("");
		}
		return builder.toString();

	}
	/**
	 * 批量删除对应的value
	 * @param keys
	 */
	public void remove(Object... keys) {
		if(keys != null) {
			for(Object key : keys) {
				if(!String.valueOf(key).startsWith(REDIS_PRE)) {
					key = REDIS_PRE + String.valueOf(key);
				}
				redisTemplate.delete(key);
			}
		}
	}

	/**
	 * 根据泛型删除对应的value
	 * @param pattern
	 */
	public void removePattern(String pattern) {
		Set keys = redisTemplate.keys(pattern+"*");
		if(keys != null && !keys.isEmpty()) {
			remove(keys.toArray());
		}
	}

	/**
	 * 根据条件获取缓存
	 * @param 实体的dao
	 * @param method 操作的方法
	 * @param params 方法参数
	 * @return
	 */
	public Object getValue(Object dao, String method, Object... params) {
		return getValue(generateKey(dao, method, params));
	}

	/**
	 * 根据key获取缓存
	 * @param key
	 * @return
	 */
	public Object getValue(String key) {
		Object obj = null;
		ValueOperations opsForValue = redisTemplate.opsForValue();
		obj = opsForValue.get(REDIS_PRE + key);
		return obj;
	}

	/**
	 * 写入缓存内容
	 * @param value 写入的内容
	 * @param 实体的dao
	 * @param method 操作的方法
	 * @param params 方法参数
	 * @return
	 */
	public boolean setValue(Object value, Object dao, String method, Object... params) {
		return setValue(generateKey(dao, method, params), value);
	}

	/**
	 * 写入缓存内容
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean setValue(String key, Object value) {
		boolean flag = false;
		try {
			ValueOperations opsForValue = redisTemplate.opsForValue();
			opsForValue.set(REDIS_PRE + key, value);
			flag = true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 写入缓存内容
	 * @param key
	 * @param value
	 * @param expireTime 缓存时间:单位秒
	 * @return
	 */
	public boolean setValue(String key, Object value, long expireTime) {
		boolean flag = false;
		try {
			ValueOperations opsForValue = redisTemplate.opsForValue();
			opsForValue.set(REDIS_PRE + key, value);
			redisTemplate.expire(REDIS_PRE + key, expireTime, TimeUnit.SECONDS);
			flag = true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
