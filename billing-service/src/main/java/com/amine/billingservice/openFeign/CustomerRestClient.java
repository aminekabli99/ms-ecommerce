package com.amine.billingservice.openFeign;

import com.amine.billingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "customer-service")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable("id") Long id);

    @GetMapping("/customers")
    public PagedModel<Customer> getAllCustomers();
}
