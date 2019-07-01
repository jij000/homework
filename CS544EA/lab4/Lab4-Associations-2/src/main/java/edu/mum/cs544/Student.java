package edu.mum.cs544;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Student {
	@Id
	@GeneratedValue
	private long studentId;
	private String studentName;
	@ManyToMany
	private List<Course> courseList = new ArrayList<>();
}
