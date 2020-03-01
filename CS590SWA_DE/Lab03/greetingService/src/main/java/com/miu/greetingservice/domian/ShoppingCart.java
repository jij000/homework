package com.miu.greetingservice.domian;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class ShoppingCart {
    @Id
    private String id;
    private String customerId;
    private Product product;
    private String number;
}