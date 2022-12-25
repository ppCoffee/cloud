/**
 * LoadBlanceHelper.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月23日
 */



package com.evmtv.consumer.lb;


import java.net.URI;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Resource;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import com.evmtv.consumer.lb.impl.ILoadBlance;


@Component
public class LoadBlanceImpl implements ILoadBlance{
	
	@Resource
	private DiscoveryClient discoveryClient;
	
	private AtomicInteger atomicInteger = new AtomicInteger(0);
	
	public final int getAndIncrement() {
		
		int current;
		int next;
		do {
			current = atomicInteger.get();
			next = current >= Integer.MAX_VALUE ? 0 : current+1;
		}while(!atomicInteger.compareAndSet(current, next));
		
		System.out.println("第" + next + "次访问");
		
		return next;
	}
	
	public String roundBlance(String applicationname) {
		
		URI uri = null;
		
		List<ServiceInstance> instances = discoveryClient.getInstances(applicationname);
		if(instances == null || instances.size() == 0) {
			return null;
		}
		
		int index = getIndexFromRoundBlance(instances);
		
		uri = instances.get(index).getUri();
		
		return uri.toString();
	}


	private int getIndexFromRoundBlance(List<ServiceInstance> instances) {
		
		return getAndIncrement() % instances.size();
	}
}
