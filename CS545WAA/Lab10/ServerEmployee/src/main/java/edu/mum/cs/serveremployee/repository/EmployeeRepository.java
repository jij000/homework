package edu.mum.cs.serveremployee.repository;

import edu.mum.cs.serveremployee.domain.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    @Query("select e from Employee e where e.number = ?1 ")
    Employee locateOneEmployeeByHisNumber(String number);
}
