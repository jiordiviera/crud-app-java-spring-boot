package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> saveEmloyee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }
//    Get all rest api
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployee();
    }
//    Get by Id rest api
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long employeeID) {
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeID), HttpStatus.OK);
    }
//    Update rest api
    @PutMapping("{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") long employeeID, @RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,employeeID), HttpStatus.OK);
    }

    //Delete Rest Api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
        //delete employee from db
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee deleted Successfully.",HttpStatus.OK);
    }
}
