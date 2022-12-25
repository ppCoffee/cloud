package com.evmtv.consumer;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.evmtv.ribbon.RibbonRule;



@EnableEurekaClient
@SpringBootApplication
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = RibbonRule.class)
public class ConsumerApplication {

	public static void main(String[] args) {

		SpringApplication.run(ConsumerApplication.class, args);

	}
	
}
