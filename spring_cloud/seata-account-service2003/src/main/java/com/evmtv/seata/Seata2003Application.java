package com.evmtv.seata;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class Seata2003Application {

	public static void main(String[] args) {

		SpringApplication.run(Seata2003Application.class, args);
	}
	
}
