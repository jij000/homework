package edu.mum.cs544;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@ToString
@Entity
//@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@Inheritance(strategy= InheritanceType.JOINED)
public class Product {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;
}
