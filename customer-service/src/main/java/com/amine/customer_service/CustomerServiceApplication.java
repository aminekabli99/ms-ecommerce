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
			for(int i=0;i<3;i++){
				Customer c=Customer.builder()
						.id(i)
						.name("amine"+i)
						.email("aminekabli"+1+"@gmail.com")
						.phone("06"+i)
						.build();
				customerRepo.save(c);
			}
		};
	};

}
