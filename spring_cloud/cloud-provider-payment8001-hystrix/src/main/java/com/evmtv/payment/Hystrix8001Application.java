package com.evmtv.payment;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SuppressWarnings("deprecation")
@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class Hystrix8001Application {

	public static void main(String[] args) {

		SpringApplication.run(Hystrix8001Application.class, args);
	}
	
}
