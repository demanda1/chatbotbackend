package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MyChatbotService;

@SpringBootApplication
@EnableDiscoveryClient
@Configuration
@EnableAutoConfiguration
@EnableEurekaClient
@RestController
public class MyChatbotApplication {
	  @RequestMapping("/")
	  public String home() {
	    return "This is a trivial service that demonstrates how a Eureka Client can register with a Eureka Server";
	  }
	  
	  @Autowired MyChatbotService chatbotservice;
		@GetMapping("/send/{msg}")
		public Object sendMessage(@PathVariable String msg){
			System.out.println(msg);
			List<String> m=new ArrayList<String>();
			String message=chatbotservice.botService(msg);
			m.add(message);
			return m;
		}

	public static void main(String[] args) {
		SpringApplication.run(MyChatbotApplication.class, args);
	}

}
