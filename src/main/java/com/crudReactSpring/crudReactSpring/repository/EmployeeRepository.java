package com.crudReactSpring.crudReactSpring.repository;

import com.crudReactSpring.crudReactSpring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
