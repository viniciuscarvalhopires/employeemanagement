package com.vini.employeemanager.service;

import com.vini.employeemanager.model.Employee;
import com.vini.employeemanager.repo.EmployeeRepo;
import com.vini.employeemanager.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());

        return employeeRepo.save(employee);
    }


    public List<Employee> findAllEmployee(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id){

        return employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by ID " + id + "was not found"));
    }

    public void deleteEmployee(Long  id){
        employeeRepo.deleteById(id);
    }

}
