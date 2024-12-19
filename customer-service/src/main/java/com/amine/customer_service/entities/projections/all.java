package com.amine.customer_service.entities.projections;

import com.amine.customer_service.entities.Customer;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "all",types = Customer.class)
public interface all {
    String getName();
    String getEmail();
    String getPhone();
}
