package com.crudReactSpring.crudReactSpring.service.impl;

import com.crudReactSpring.crudReactSpring.dto.EmployeeDTO;
import com.crudReactSpring.crudReactSpring.entity.Employee;
import com.crudReactSpring.crudReactSpring.exception.ResourceNotFoundException;
import com.crudReactSpring.crudReactSpring.mapper.EmployeeMapper;
import com.crudReactSpring.crudReactSpring.repository.EmployeeRepository;
import com.crudReactSpring.crudReactSpring.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeId(Long employeeId) {
      Employee employee = employeeRepository.findById(employeeId).orElseThrow( () ->
                new ResourceNotFoundException("Employee doesnt exist with given id: " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO updateEmployees(Long employeeId, EmployeeDTO updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee doesnt exist with given id: " + employeeId)
        );

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updateEmployeeObj = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updateEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee doesnt exist with given id: " + employeeId)
        );

        employeeRepository.deleteById(employeeId);
    }
}
