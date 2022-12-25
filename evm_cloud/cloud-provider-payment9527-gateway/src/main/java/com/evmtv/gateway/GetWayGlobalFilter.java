/**
 * GetWayGlobalFilter.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月25日
 */



package com.evmtv.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class GetWayGlobalFilter implements GlobalFilter,Ordered{
	
	/**
	 * 过滤级别 数字越小越先考虑
	 */
	@Override
	public int getOrder() {
		return 0;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		
		String token = exchange.getRequest().getQueryParams().getFirst("token");
		
		if(token == null) {
			
			exchange.getResponse().setStatusCode(HttpStatus.BAD_GATEWAY);
			return exchange.getResponse().setComplete();
		}
		
		return chain.filter(exchange);
	}

}
