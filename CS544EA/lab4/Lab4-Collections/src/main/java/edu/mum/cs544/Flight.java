package edu.mum.cs544;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Flight {

    @Id
    @GeneratedValue
    private Integer id;
    private String flightName;
    @OneToMany
    @JoinColumn(name = "Flight_id")
//    @OrderColumn(name = "sequence")
    private List<Passenger> passengers = new ArrayList<>();
}
