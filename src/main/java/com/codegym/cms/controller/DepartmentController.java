package com.codegym.cms.controller;

import com.codegym.cms.model.Department;
import com.codegym.cms.model.Employee;
import com.codegym.cms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;


    @GetMapping("/department/edit/{id}")
    public ModelAndView showEditForm(@PathVariable long id){
        Department department = departmentService.findById(id);
        if(department != null) {
            ModelAndView modelAndView = new ModelAndView("/department/edit");
            modelAndView.addObject("department", department);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/department/edit/{id}")
    public String updateDepartment(@Validated @ModelAttribute Department department, BindingResult result){
        if (result.hasFieldErrors()) {
            return "/department/edit";
        }
        departmentService.save(department);
        return "redirect:/departments";
    }
    @GetMapping("/create-department")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/department/create");
        modelAndView.addObject("department", new Department());
        return modelAndView;
    }
    @PostMapping("/create-department")
    public String saveDepartment(@Validated @ModelAttribute Department department, BindingResult result){
        if (result.hasFieldErrors()) {
            return "/department/create";
        }
        departmentService.save(department);
        return "redirect:/departments";
    }


    @GetMapping("/departments")
    public ModelAndView listDepartments(Pageable pageable){
        Page<Department> departments = departmentService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/department/list");
        modelAndView.addObject("departments", departments);
        return modelAndView;
    }
    @GetMapping("/department/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable long id){
        Department department = departmentService.findById(id);
        if(department != null) {
            ModelAndView modelAndView = new ModelAndView("/department/delete");
            modelAndView.addObject("department", department);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/department/delete")
    public String deleteDepartment(@RequestParam("id") Long id){
        departmentService.delete(id);
        return "redirect:/employees";
    }

    @GetMapping("/department/view/{id}")
    public ModelAndView viewDepartment(@PathVariable("id") Long id){
        Department department = departmentService.findById(id);
        if(department == null){
            return new ModelAndView("/error.404");
        }

        Iterable<Employee> employees = departmentService.findAllByDepartment(department);

        ModelAndView modelAndView = new ModelAndView("/department/view");
        modelAndView.addObject("department", department);
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }


}
