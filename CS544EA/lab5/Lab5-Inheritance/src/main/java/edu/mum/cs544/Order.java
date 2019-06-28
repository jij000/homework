package edu.mum.cs544;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@ToString
@Entity(name="orders")
public class Order {
    @Id
    @GeneratedValue
    long orderId;
    LocalDate date;
    @ManyToOne
    Customer customer;
    @OneToMany
    List<OrderLine> orderLineList = new ArrayList<>();
}
