package com.miu.greetingservice.domian;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private String quantity;
    private String locationCode;
    private String price;
}