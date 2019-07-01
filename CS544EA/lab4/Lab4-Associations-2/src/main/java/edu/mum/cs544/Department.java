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
public class Department {

    @Id
    @GeneratedValue
    private Integer id;
    private String departmentName;
    @OneToMany(mappedBy = "employeeId")
//    @JoinColumn(name = "Flight_id")
    @OrderColumn(name = "employee_sequence")
    private List<Employee> employeeList = new ArrayList<>();
}
