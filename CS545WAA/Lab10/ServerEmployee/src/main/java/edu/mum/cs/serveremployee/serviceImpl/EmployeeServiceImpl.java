package edu.mum.cs.serveremployee.serviceImpl;

import edu.mum.cs.serveremployee.domain.Employee;
import edu.mum.cs.serveremployee.repository.EmployeeRepository;
import edu.mum.cs.serveremployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee getEmployeeByNumber(String number) {
        return employeeRepository.locateOneEmployeeByHisNumber(number);
    }
}
