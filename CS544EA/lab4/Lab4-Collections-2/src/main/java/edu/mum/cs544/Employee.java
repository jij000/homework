package edu.mum.cs544;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue
	private Long employeeId;
	private String name;
	@ManyToOne
	private Department department;
	@ManyToOne
	private Office office;
}
