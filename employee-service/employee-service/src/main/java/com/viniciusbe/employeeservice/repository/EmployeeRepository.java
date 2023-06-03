package com.viniciusbe.employeeservice.repository;

import com.viniciusbe.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
