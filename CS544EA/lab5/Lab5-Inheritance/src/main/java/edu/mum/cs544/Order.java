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
    private long orderId;
    private LocalDate date;
    @ManyToOne
    private Customer customer;
    @OneToMany
    private List<OrderLine> orderLineList = new ArrayList<>();
}
