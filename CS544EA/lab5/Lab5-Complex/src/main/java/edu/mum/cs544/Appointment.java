package edu.mum.cs544;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@ToString
@Entity
public class Appointment {
    @Id
    @GeneratedValue
    private Long id;
    private String appdate;
    @Embedded
    private Payment payment;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Doctor doctor;
}
