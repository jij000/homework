package edu.mum.cs.serveremployee.service;

import edu.mum.cs.serveremployee.domain.Employee;

public interface EmployeeService {
    Employee getEmployeeByNumber(String number);
}
