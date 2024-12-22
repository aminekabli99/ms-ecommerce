package com.amine.billingservice.openFeign;

import com.amine.billingservice.model.Customer;
import com.amine.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service")
public interface ProductRestClient {
    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") String id);
}
