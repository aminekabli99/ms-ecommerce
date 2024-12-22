package com.amine.billingservice.model;
import lombok.*;


@AllArgsConstructor @NoArgsConstructor @Builder @Getter @Setter
public class Customer {

    private int id;
    private String name;
    private String phone;
    private  String email;
}
