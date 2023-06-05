package com.viniciusbe.departmentservice;

import com.viniciusbe.departmentservice.mapper.DepartmentMapper;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DepartmentServiceApplication {

	@Bean
	public DepartmentMapper departmentMapper() {
		return new DepartmentMapper(new ModelMapper());
	}
	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
