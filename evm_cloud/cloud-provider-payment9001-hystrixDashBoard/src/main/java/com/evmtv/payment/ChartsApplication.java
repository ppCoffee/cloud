package com.evmtv.payment;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@SpringBootApplication
public class ChartsApplication {

	public static void main(String[] args) {

		SpringApplication.run(ChartsApplication.class, args);

	}
	
}
