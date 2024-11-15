package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    //save employee in database
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    //    Get all employee form database
    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    //    Get employee using ID
    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new RuntimeException();
        }
    }

    //    Update employee
    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Employee not found")
        );
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
//        save
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    //    Delete employee
    @Override
    public void deleteEmployee(long id) {
//        check data
        employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
//        delete
        employeeRepository.deleteById(id);
    }
}
