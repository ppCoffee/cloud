package com.evmtv.sentinel;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class SentinelPayment9004Application {

	public static void main(String[] args) {

		SpringApplication.run(SentinelPayment9004Application.class, args);
	}
	
}
