package com.evmtv.payment;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class Zookeeper8004Application {

	public static void main(String[] args) {

		SpringApplication.run(Zookeeper8004Application.class, args);
	}
	
}
