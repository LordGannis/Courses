package com.microservices.cloud.springcloudserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringcloudserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudserverApplication.class, args);
	}
}
