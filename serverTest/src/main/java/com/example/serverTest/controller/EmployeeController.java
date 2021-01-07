package com.example.serverTest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.serverTest.model.Employee;
import org.springframework.web.bind.annotation.*;
@RestController
public class EmployeeController
{
    @GetMapping(value = "/healthcheck", produces = "application/json; charset=utf-8")
    public String getHealthCheck()
    {
        return "{ \"isWorking\" : true }";
    }
    @GetMapping("/employees")
    public List<Employee> getEmployees()
    {
        List<Employee> employeesList = new ArrayList<Employee>();
        employeesList.add(new Employee(1,"lokesh","gupta","test@gmail.com"));
        return employeesList;
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable Integer id)
    {
        Employee emp = new Employee(id,"lokesh","gupta","test@gmail.com");
        return emp;
    }

    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@RequestBody Employee newEmployee, @PathVariable Integer id)
    {
        Employee emp = newEmployee;
        return emp;
    }

    @DeleteMapping(value = "/employee/{id}", produces = "application/json; charset=utf-8")
    public String deleteEmployee(@PathVariable Long id) {
        return "{ \"success\" : true }";
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee newEmployee)
    {
        Integer id = new Random().nextInt();
        Employee emp = new Employee(id, newEmployee.firstName(), newEmployee.lastName(), newEmployee.email());
        return emp;
    }
}
