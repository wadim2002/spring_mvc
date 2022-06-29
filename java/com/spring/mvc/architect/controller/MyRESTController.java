package com.spring.mvc.architect.controller;


import com.spring.mvc.architect.dao.EmployeeDAO;
import com.spring.mvc.architect.entity.Employee;
import com.spring.mvc.architect.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    //private EmployeeService employeeService;
    private EmployeeDAO myEmployeeDAO;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        List<Employee> allEmployees = myEmployeeDAO.getAllEmployees();
        return allEmployees;
    }
}
