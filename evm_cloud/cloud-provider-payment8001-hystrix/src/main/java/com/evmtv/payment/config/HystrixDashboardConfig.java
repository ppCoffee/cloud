/**
 * HystrixDashboardConfig.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月25日
 */



package com.evmtv.payment.config;

import javax.servlet.Servlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@Configuration
public class HystrixDashboardConfig {
	
		//hystrix dashboard需要的bug修复，由于cloud更新以后未能修复此bug
		@SuppressWarnings("unchecked")
		@Bean
		ServletRegistrationBean getServlet(){
			
			@SuppressWarnings({ "rawtypes"})
			ServletRegistrationBean srb = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
			srb.setLoadOnStartup(1);
			srb.addUrlMappings("/hystrix.stream");
			srb.setName("hystrix.stream");
			
			return srb;
		}
}
