package com.cloud.whp.common.gateway.support;

import com.cloud.whp.common.core.constant.CommonConstant;
import com.cloud.whp.common.gateway.vo.RouteDefinitionVo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * @author whp
 * @date 2018年12月19日
 * <p>
 * redis 保存路由信息，优先级比配置文件高
 */
@Slf4j
@Component
@AllArgsConstructor
public class RedisRouteDefinitionWriter implements RouteDefinitionRepository {
	private final RedisTemplate redisTemplate;

	@Override
	public Mono<Void> save(Mono<RouteDefinition> route) {
		return route.flatMap(r -> {
			RouteDefinitionVo vo = new RouteDefinitionVo();
			BeanUtils.copyProperties(r, vo);
			log.info("保存路由信息{}", vo);
			redisTemplate.opsForHash().put(CommonConstant.ROUTE_KEY, r.getId(), vo);
			return Mono.empty();
		});
	}

	@Override
	public Mono<Void> delete(Mono<String> routeId) {
		routeId.subscribe(id -> {
			log.info("删除路由信息{}", id);
			redisTemplate.opsForHash().delete(CommonConstant.ROUTE_KEY, id);
		});
		return Mono.empty();
	}


	/**
	 * 动态路由入口
	 *
	 * @return
	 */
	@Override
	public Flux<RouteDefinition> getRouteDefinitions() {
		redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(RouteDefinitionVo.class));
		List<RouteDefinitionVo> values = redisTemplate.opsForHash().values(CommonConstant.ROUTE_KEY);
		List<RouteDefinition> definitionList = new ArrayList<>();
		values.forEach(vo -> {
			RouteDefinition routeDefinition = new RouteDefinition();
			BeanUtils.copyProperties(vo, routeDefinition);
			definitionList.add(vo);
		});
		log.debug("redis 中路由定义条数： {}， {}", definitionList.size(), definitionList);
		return Flux.fromIterable(definitionList);
	}
}
