package com.jrp.projectmanagement.controllers;

import com.jrp.projectmanagement.dao.EmployeeRepository;
import com.jrp.projectmanagement.dao.ProjectRepository;
import com.jrp.projectmanagement.entities.Employee;
import com.jrp.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        Project aProject = new Project();
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("project", aProject);
        model.addAttribute("allEmployees", employees);

        return "projects/new-project";
    }


    @GetMapping("/list")
    public String displayProjectList(Model model) {
        List<Project> projectList = projectRepository.findAll();
        model.addAttribute("projectList", projectList);
        return "projects/list-projects";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model, @RequestParam List<Long> employeeList) {
        projectRepository.save(project);
        Iterable<Employee> chosenEmployees = employeeRepository.findAllById(employeeList);
        chosenEmployees.forEach(employee -> {
            employee.setProject(project);
            employeeRepository.save(employee);
        });
        //use a redirect to prevent a duplicate submissions
        return "redirect:/projects/list";
    }
}
