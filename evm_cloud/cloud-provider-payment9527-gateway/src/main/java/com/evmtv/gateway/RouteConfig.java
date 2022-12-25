/**
 * RouteServiceImpl.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月25日
 */



package com.evmtv.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {
	
	@Bean
	RouteLocator baiduLocator(RouteLocatorBuilder builder) {
		
		RouteLocatorBuilder.Builder routes = builder.routes();
		routes.route("idName", r -> r.path("/guoji").uri("http://news.baidu.com")).build();
		
		return routes.build();
	}
	
}
