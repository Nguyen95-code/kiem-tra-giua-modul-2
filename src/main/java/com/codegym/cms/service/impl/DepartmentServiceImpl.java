package com.codegym.cms.service.impl;

import com.codegym.cms.model.Department;
import com.codegym.cms.model.Employee;
import com.codegym.cms.repository.DepartmentRepository;
import com.codegym.cms.repository.EmployeeRepository;
import com.codegym.cms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Page<Department> findAll(Pageable pageable) {
        return departmentRepository.findAll(pageable);
    }

    @Override
    public void delete(long id) {
        Department department = findById(id);
        List<Employee> employees = (List<Employee>) findAllByDepartment(department);
        for (int i = 0; i < employees.size(); i++) {
            employeeRepository.delete(employees.get(i));
        }

        departmentRepository.delete(id);
    }

    @Override
    public Department findById(long id) {
        return departmentRepository.findOne(id);
    }

    @Override
    public Iterable<Department> findAll() {
        return departmentRepository.findAll();
    }


    @Override
    public void save(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public Iterable<Employee> findAllByDepartment(Department department) {
        return employeeRepository.findAllByDepartment(department);
    }
}
