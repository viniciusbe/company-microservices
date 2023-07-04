package com.viniciusbe.departmentservice;

import com.viniciusbe.departmentservice.mapper.DepartmentMapper;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(
		info = @Info(
				title = "Department Service REST APIs",
				description = "Department Service REST APIs Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Vinícius",
						email = "contato@viniciusbernardes.dev"
				),
				license = @License(
						name = "Apache 2.0"
				)
		)
)
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
