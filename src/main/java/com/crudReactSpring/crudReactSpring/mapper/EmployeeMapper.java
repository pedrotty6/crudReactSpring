package com.crudReactSpring.crudReactSpring.mapper;

import com.crudReactSpring.crudReactSpring.dto.EmployeeDTO;
import com.crudReactSpring.crudReactSpring.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDTO mapToEmployeeDto(Employee employee){
        return new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
        }

    public static Employee mapToEmployee(EmployeeDTO employeeDTO) {
        return new Employee(
                employeeDTO.getId(),
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getEmail()
        );
    }
}
