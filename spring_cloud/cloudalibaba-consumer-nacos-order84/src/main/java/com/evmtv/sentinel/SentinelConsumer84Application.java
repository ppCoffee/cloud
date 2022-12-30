package com.evmtv.sentinel;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.evmtv.sentinel.config.LoadBalancerConfig;

@LoadBalancerClient(name = "nacos-payment-provider", configuration = LoadBalancerConfig.class)
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class SentinelConsumer84Application {

	public static void main(String[] args) {

		SpringApplication.run(SentinelConsumer84Application.class, args);
	}
	
}
