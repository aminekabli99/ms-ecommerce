package com.amine.inventory_service;

import com.amine.inventory_service.entities.Product;
import com.amine.inventory_service.repositories.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}



	@Bean
	CommandLineRunner commandLineRunner(ProductRepo productRepo){
		return args -> {
			for(int i=0;i<3;i++){
				productRepo.save(Product.builder()
								.id(UUID.randomUUID().toString())
								.name("product"+i)
								.price(i)
								.quantity(i)

						.build());
			}
		};
	}
}
