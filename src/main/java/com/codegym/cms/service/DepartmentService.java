package com.codegym.cms.service;

import com.codegym.cms.model.Department;
import com.codegym.cms.model.Employee;
import org.springframework.data.domain.Page;

public interface DepartmentService extends GenaralService<Department> {
    void save(Department department);
    Iterable<Employee> findAllByDepartment(Department department);
}
