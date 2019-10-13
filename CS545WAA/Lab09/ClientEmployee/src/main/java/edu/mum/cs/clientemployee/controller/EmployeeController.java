package edu.mum.cs.clientemployee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    @GetMapping("/")
    public String addEmployee(){
        return "employee";
    }
}
