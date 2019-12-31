package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableDiscoveryClient
@Configuration
@EnableAutoConfiguration
@EnableEurekaClient
public class MyChatbotApplication {
	  @RequestMapping("/")
	  public String home() {
	    return "This is a trivial service that demonstrates how a Eureka Client can register with a Eureka Server";
	  }


	public static void main(String[] args) {
		SpringApplication.run(MyChatbotApplication.class, args);
	}

}
