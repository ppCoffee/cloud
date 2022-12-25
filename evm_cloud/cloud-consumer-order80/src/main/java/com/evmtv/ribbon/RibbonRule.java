/**
 * RibbonRule.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月23日
 */



package com.evmtv.ribbon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration
public class RibbonRule{
	
	@Bean
	IRule rule() {
		
		//默认是round轮询
		return new RoundRobinRule();
		
		/*
		 * 无法使用轮询以外负载策略，估计是eurekaClient和ribbon的版本有冲突
		 */
		//随机访问
		//return new RandomRule(); 
		
	}

}
