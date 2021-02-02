package com.jrp.projectmanagement.controllers;

import com.jrp.projectmanagement.dao.EmployeeRepository;
import com.jrp.projectmanagement.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/new")
    public String displayEmployeeForm(Model model) {
        Employee anEmp = new Employee();
        model.addAttribute("employee", anEmp);
        return "employees/new-employee";
    }

    @GetMapping("/list")
    public String displayEmployeeList(Model model) {
        List<Employee> empList = employeeRepository.findAll();
        model.addAttribute("empList", empList);
        return "employees/list-employees";
    }

    @PostMapping("/save")
    public String createEmploye(Employee emp) {
        employeeRepository.save(emp);
        return "redirect:/employees/list";
    }

}
