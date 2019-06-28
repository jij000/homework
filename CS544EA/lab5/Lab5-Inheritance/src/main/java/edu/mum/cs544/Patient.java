package edu.mum.cs544;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@ToString
@Entity
@SecondaryTable(name="Address")
public class Patient {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(table="Address")
    private String street;
    @Column(table="Address")
    private String zip;
    @Column(table="Address")
    private String city;
}
