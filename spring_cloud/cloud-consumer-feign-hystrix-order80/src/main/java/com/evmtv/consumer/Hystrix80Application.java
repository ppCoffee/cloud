package com.evmtv.consumer;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableHystrix
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class Hystrix80Application {

	public static void main(String[] args) {

		SpringApplication.run(Hystrix80Application.class, args);
	}
	
}
