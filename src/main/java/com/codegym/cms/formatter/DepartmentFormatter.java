package com.codegym.cms.formatter;

import com.codegym.cms.model.Department;
import com.codegym.cms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class DepartmentFormatter implements Formatter<Department> {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentFormatter(DepartmentService categoryService) {
        this.departmentService = categoryService;
    }

    @Override
    public Department parse(String text, Locale locale) {
        return departmentService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Department object, Locale locale) {
        return "[" + object.getId() + ", " + object.getName() + "]";
    }
}
