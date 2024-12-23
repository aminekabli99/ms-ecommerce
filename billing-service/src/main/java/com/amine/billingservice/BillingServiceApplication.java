package com.amine.billingservice;

import com.amine.billingservice.entities.Bill;
import com.amine.billingservice.entities.ProductItem;
import com.amine.billingservice.model.Customer;
import com.amine.billingservice.model.Product;
import com.amine.billingservice.openFeign.CustomerRestClient;
import com.amine.billingservice.openFeign.ProductRestClient;
import com.amine.billingservice.repositories.BillRepo;
import com.amine.billingservice.repositories.ProductItemRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BillRepo billRepo,
                                        ProductItemRepo productItemRepo,
                                        CustomerRestClient customerRestClient,
                                        ProductRestClient productRestClient) {
        return args -> {
            Collection<Customer> customers =customerRestClient.getAllCustomers().getContent();
            Collection<Product> products=productRestClient.getProducts().getContent();
            customers.forEach(customer -> {
                Bill bill = Bill.builder()
                        .billDate(new Date())
                        .customerId(customer.getId())
                .build();
                billRepo.save(bill);

                products.forEach(product -> {
                    ProductItem productItem=ProductItem.builder()
                            .bill(bill)
                             .productId(product.getId())
                            .unitPrice(product.getPrice())
                            .quantity(1+new Random().nextInt(10))
                            .build();
                    productItemRepo.save(productItem);
                });
            });
        };
    }

}
