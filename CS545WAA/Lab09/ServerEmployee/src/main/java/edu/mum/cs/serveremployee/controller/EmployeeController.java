package edu.mum.cs.serveremployee.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.cs.serveremployee.domain.Employee;

@RestController
public class EmployeeController {

    @CrossOrigin(value = { "http://localhost:8082" }, maxAge = 5000)
    @PostMapping("/addEmployee")
    public Employee addEmployee(@Valid @RequestBody Employee employee) {
        System.out.println(employee);
        // save to DB
        employee.setFirstName(employee.getFirstName() + "Rest");
        ;
        employee.setLastName(employee.getLastName() + "Rest");
        ;
        employee.setEmail(employee.getEmail() + "Rest");
        ;
        return employee;
    }

}
