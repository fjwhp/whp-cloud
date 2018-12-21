
package com.cloud.whp.common.cache;

import cn.hutool.core.util.StrUtil;
import com.cloud.whp.common.core.util.TenantContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.lang.Nullable;

import java.time.Duration;
import java.util.Map;

/**
 * redis cache 扩展cache name自动化配置
 *
 * @author whp
 * <p>
 * cachename = xx#ttl
 */
@Slf4j
public class RedisAutoCacheManager extends RedisCacheManager {
	private static final String SPLIT_FLAG = "#";
	private static final int CACHE_LENGTH = 2;

	RedisAutoCacheManager(RedisCacheWriter cacheWriter, RedisCacheConfiguration defaultCacheConfiguration,
						  Map<String, RedisCacheConfiguration> initialCacheConfigurations, boolean allowInFlightCacheCreation) {
		super(cacheWriter, defaultCacheConfiguration, initialCacheConfigurations, allowInFlightCacheCreation);
	}

	@Override
	protected RedisCache createRedisCache(String name, @Nullable RedisCacheConfiguration cacheConfig) {
		if (StrUtil.isBlank(name) || !name.contains(SPLIT_FLAG)) {
			return super.createRedisCache(name, cacheConfig);
		}
		String[] cacheArray = name.split(SPLIT_FLAG);
		if (cacheArray.length < CACHE_LENGTH) {
			return super.createRedisCache(name, cacheConfig);
		}
		String cacheName = cacheArray[0] + ":" + TenantContextHolder.getTenantId();
		if (cacheConfig != null) {
			long cacheAge = Long.getLong(cacheArray[1], -1);
			cacheConfig = cacheConfig.entryTtl(Duration.ofSeconds(cacheAge));
		}
		return super.createRedisCache(cacheName, cacheConfig);
	}

	@Override
	public Cache getCache(String name) {
		return super.getCache(name + ":" + TenantContextHolder.getTenantId());
	}
}
