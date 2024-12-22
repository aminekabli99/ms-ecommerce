package com.amine.billingservice.repositories;

import com.amine.billingservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductItemRepo extends JpaRepository<ProductItem, String>, JpaSpecificationExecutor<ProductItem> {
}
