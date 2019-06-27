package edu.mum.cs544;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Owner {
    @Id
    @GeneratedValue
	private Long id;
	private String name;
	private String address;
	
	public Owner(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	
	
}
