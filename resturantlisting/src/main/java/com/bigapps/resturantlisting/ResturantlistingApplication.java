package com.bigapps.resturantlisting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ResturantlistingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResturantlistingApplication.class, args);
	}

}
