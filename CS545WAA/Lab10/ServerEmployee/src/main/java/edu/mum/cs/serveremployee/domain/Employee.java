package edu.mum.cs.serveremployee.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotEmpty
    private String firstName;
    @NotEmpty
    @Size(min = 3, max = 10)
    private String lastName;
    @NotEmpty
    private String email;
    @NotEmpty
    private String number;
    @OneToOne
    private Address address;

}
