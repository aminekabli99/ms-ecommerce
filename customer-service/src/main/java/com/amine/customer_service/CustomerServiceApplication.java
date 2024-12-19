package com.amine.customer_service;

import com.amine.customer_service.entities.Customer;
import com.amine.customer_service.repositories.CustomerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepo customerRepo){
		return args -> {
			customerRepo.save(Customer.builder()
					.id(1)
					.name("amine")
					.email("aminekabli@gmail.com")
							.phone("069554555555")
					.build());
		};
	}

}
