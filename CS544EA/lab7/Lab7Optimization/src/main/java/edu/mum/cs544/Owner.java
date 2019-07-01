package edu.mum.cs544;

import org.hibernate.annotations.*;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Owner {
	@Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
	@OneToMany (cascade={CascadeType.PERSIST})
	@JoinColumn (name="clientid")
	// a) Add the @LazyCollection with option EXTRA to the association and run App again.
	// [OUTPUT]>>> : To fetch this data from the database took 51103 milliseconds.
//	@LazyCollection(LazyCollectionOption.EXTRA)
	// b) Remove the @LazyCollection, and modify the mapping for Owner.java to
	//use batch fetching, batch size 10. Also check the time when using sizes 5
	//and 50.
	// [OUTPUT]>>> : To fetch this data from the database took 35596 milliseconds.
	// [OUTPUT, when size = 50]>>> : To fetch this data from the database took 33670 milliseconds.
//	@BatchSize(size=10)
	// c) Modify the mapping to use the sub-select strategy instead of batch fetching.
	// [OUTPUT]>>> : To fetch this data from the database took 18575 milliseconds.
//	@Fetch(FetchMode.SUBSELECT)
    private List<Pet> pets;
    
	public Owner() {
	}
	public Owner(String name) {
		super();
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Pet> getPets() {
		return pets;
	}
	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}
    
	
    
}
