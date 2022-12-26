/**
 * GatewayFilter.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月27日
 */

package com.evmtv.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

/**
 * 此段代码只能过滤配置文件的断言路径，手写config需要额外代码操作
 * @author Administrator
 *
 */
@Component
public class GatewayFilter implements GlobalFilter,Ordered {
	
	@Override
	public int getOrder() {
		return 0; //数值越小过滤优先级越高
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		
		 String token = exchange.getRequest().getQueryParams().getFirst("token");
	        if(!StringUtils.hasText(token) || !token.equals("1")){
	            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);//给人家一个回应
	            return exchange.getResponse().setComplete();
	        }
	        
	        return chain.filter(exchange);
	}

}
