package edu.mum.cs544;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Integer customerId;
    private String customerName;
    @OneToMany
    @JoinColumn
    private List<Reservation> reservationList = new ArrayList<>();
}
