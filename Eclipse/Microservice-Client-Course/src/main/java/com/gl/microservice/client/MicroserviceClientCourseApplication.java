package com.gl.microservice.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceClientCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceClientCourseApplication.class, args);
	}

}
