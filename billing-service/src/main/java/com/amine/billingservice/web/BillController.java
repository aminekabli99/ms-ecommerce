package com.amine.billingservice.web;

import com.amine.billingservice.entities.Bill;
import com.amine.billingservice.model.Customer;
import com.amine.billingservice.model.Product;
import com.amine.billingservice.openFeign.CustomerRestClient;
import com.amine.billingservice.openFeign.ProductRestClient;
import com.amine.billingservice.repositories.BillRepo;
import com.amine.billingservice.repositories.ProductItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BillController {
    @Autowired private CustomerRestClient customerRestClient;
    @Autowired private ProductRestClient productRestClient;
    @Autowired private BillRepo billRepo;
    @Autowired private ProductItemRepo productItemRepo;

    @GetMapping("/getBills")
    public List<Bill> getBills() {
        List<Bill> bills =billRepo.findAll();
        bills.forEach(b->{
            Customer customer=customerRestClient.getCustomer(b.getCustomerId());
            b.setCustomer(customer);
        });
        return bills;
    }
    @GetMapping("/getBill/{id}")
    public Bill getBill(@PathVariable("id") Long id) {
        Bill bill =billRepo.findById(id).get();
        Customer customer=customerRestClient.getCustomer(bill.getCustomerId());
        bill.getItems().forEach((item)->{
            Product product=productRestClient.getProduct(item.getProductId());
            item.setProduct(product);
        });
        bill.setCustomer(customer);
        return bill;

    }

}
