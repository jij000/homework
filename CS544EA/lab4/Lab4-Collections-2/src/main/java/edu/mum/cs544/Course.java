package edu.mum.cs544;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue
    private Integer courseId;
    private String courseName;
    @ManyToMany(mappedBy = "courseList")
//    @JoinTable(name = "course_student")
    private List<Student> studentList = new ArrayList<>();

}
