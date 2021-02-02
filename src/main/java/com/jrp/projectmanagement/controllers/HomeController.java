package com.jrp.projectmanagement.controllers;

import com.jrp.projectmanagement.dao.EmployeeRepository;
import com.jrp.projectmanagement.dao.ProjectRepository;
import com.jrp.projectmanagement.entities.Employee;
import com.jrp.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/home")
    public String displayHome(Model model) {
        //we ara quering database for projects
        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projects", projects);

        //we ara quering database for lists
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);

        return "home/home";
    }

    @GetMapping("/")
    public String redirectHome() {
        return "redirect:/home";
    }
}
