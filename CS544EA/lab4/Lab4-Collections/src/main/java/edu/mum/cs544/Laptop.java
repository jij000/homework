package edu.mum.cs544;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Laptop {
    @Id
    @GeneratedValue
    private Integer id;
    private String model;
    @ManyToOne
    private Employee employee;
}
