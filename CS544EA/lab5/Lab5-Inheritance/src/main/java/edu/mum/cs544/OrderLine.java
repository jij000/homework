package edu.mum.cs544;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@Entity
public class OrderLine {
    @Id
    @GeneratedValue
    long orderId;
    int quantity;
    @ManyToOne
    Product product;
}
