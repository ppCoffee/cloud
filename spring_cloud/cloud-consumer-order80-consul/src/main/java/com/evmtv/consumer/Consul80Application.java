package com.evmtv.consumer;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class Consul80Application {

	public static void main(String[] args) {

		SpringApplication.run(Consul80Application.class, args);
	}
	
}
