package com.amine.billingservice.openFeign;

import com.amine.billingservice.model.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "customer-service")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerServiceCB",fallbackMethod = "getDefaultCustomer")
    public Customer getCustomer(@PathVariable("id") Long id);

    @GetMapping("/customers")
    public PagedModel<Customer> getAllCustomers();


    default Customer getDefaultCustomer(Long id,Exception exception) {
        return Customer.builder()
                .id(id)
                .name("amineDF")
                .email("amineDF@gmail.com")
                .phone("123456789")
                .build();
    }
}



