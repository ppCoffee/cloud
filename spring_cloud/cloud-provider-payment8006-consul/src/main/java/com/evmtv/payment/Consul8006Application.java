package com.evmtv.payment;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class Consul8006Application {

	public static void main(String[] args) {

		SpringApplication.run(Consul8006Application.class, args);
	}
	
}
