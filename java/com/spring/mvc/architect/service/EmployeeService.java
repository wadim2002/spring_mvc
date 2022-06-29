package com.spring.mvc.architect.service;



import com.spring.mvc.architect.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeService {

    @Transactional
    public abstract List<Employee> getAllEmployees();

    @Transactional
    public abstract void saveEmployee(Employee employee);
    @Transactional
    public abstract Employee getEmployee(int id);
    @Transactional
    public abstract void deleteEmployee(int id);
}
