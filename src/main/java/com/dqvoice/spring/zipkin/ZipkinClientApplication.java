package com.dqvoice.spring.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
public class ZipkinClientApplication {

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@GetMapping("/hi")
	public String hi() {
		return this.restTemplate().getForEntity("http://localhost:9081/hi", String.class).getBody();
	}

	public static void main(String[] args) {
		SpringApplication.run(ZipkinClientApplication.class, args);
	}
}
