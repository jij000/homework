package edu.mum.cs544;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@Entity
public class School {
    @Id
    @GeneratedValue
    private Integer id;
    private String schoolName;
    @OneToMany
    @JoinColumn(name="School_id")
    @MapKeyColumn(name="studentId")
    private Map<String, Student> studentMap = new HashMap<>();
}
