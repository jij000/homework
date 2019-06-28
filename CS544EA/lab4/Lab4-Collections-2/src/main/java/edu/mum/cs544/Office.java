package edu.mum.cs544;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Office {
    @Id
    @GeneratedValue
    private Long officeId;
    private String officeName;
    @OneToMany(mappedBy = "employeeId")
//    @JoinColumn(name = "Flight_id")
    @OrderColumn(name = "employee_office_sequence")
    private List<Employee> employeeList = new ArrayList<>();
}
