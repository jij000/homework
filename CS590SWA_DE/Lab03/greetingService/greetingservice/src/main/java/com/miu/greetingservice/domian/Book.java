package com.miu.greetingservice.domian;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Book {
    @Id
    private String isbn;
    private String author;
    private String title;
    private String price;
}