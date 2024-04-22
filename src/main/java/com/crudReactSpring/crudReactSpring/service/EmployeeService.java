package com.crudReactSpring.crudReactSpring.service;

import java.util.List;
import com.crudReactSpring.crudReactSpring.dto.EmployeeDTO;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeId(Long employeeId);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO updateEmployees(Long employeeId, EmployeeDTO updatedEmployee);

    void deleteEmployee(Long employeeId);
}
