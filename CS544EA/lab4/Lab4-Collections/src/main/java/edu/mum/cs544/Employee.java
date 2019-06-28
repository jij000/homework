package edu.mum.cs544;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue
	private Long id;
	private String name;
	
	@OneToMany(mappedBy="employee")
	private Set<Laptop> laptops	= new HashSet<>();
	
}
