package edu.mum.cs.serveremployee.controller;

import javax.validation.Valid;

import edu.mum.cs.serveremployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.mum.cs.serveremployee.domain.Employee;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/getEmployee/{number}")
    public Employee addEmployee(@PathVariable String number) {
        Employee employee = employeeService.getEmployeeByNumber(number);
        System.out.println(employee);
        return employee;
    }

}
