package com.codegym.cms.service;

import com.codegym.cms.model.Department;
import com.codegym.cms.model.Employee;
import com.codegym.cms.model.EmployeeForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface EmployeeService extends GenaralService{
    void save(EmployeeForm employeeForm);
    Page<Employee> findAllByNameContaining(String name, Pageable pageable);
    Employee getEmployee(EmployeeForm employeeForm);

}
