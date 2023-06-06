package com.viniciusbe.employeeservice;

import com.viniciusbe.employeeservice.mapper.EmployeeMapper;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class EmployeeServiceApplication {

	@Bean
	public EmployeeMapper employeeMapper() {
		return new EmployeeMapper(new ModelMapper());
	}

//	@Bean
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}

	@Bean
	public WebClient webClient() {
		return WebClient.builder().build();
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
