package com.amine.customer_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor@NoArgsConstructor@Builder@Getter@Setter
public class Customer {
    @Id
    private int id;
    private String name;
    private String phone;
    private  String email;
}
