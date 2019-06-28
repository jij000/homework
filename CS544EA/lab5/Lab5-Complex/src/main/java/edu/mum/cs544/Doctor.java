package edu.mum.cs544;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@ToString
@Entity
public class Doctor {
    @Id
    @GeneratedValue
    private Long id;
    private String doctorType;
    private String firstName;
    private String lastName;
}
