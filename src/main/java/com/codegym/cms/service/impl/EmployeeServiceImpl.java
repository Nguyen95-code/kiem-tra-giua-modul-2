package com.codegym.cms.service.impl;
import com.codegym.cms.model.Employee;
import com.codegym.cms.model.EmployeeForm;
import com.codegym.cms.repository.EmployeeRepository;
import com.codegym.cms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.env.Environment;

import java.io.File;
import java.io.IOException;


@PropertySource("classpath:global_config_app.properties")
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;


    @Autowired
    private Environment env;


    @Override
    public void save(EmployeeForm employeeForm) {
        Employee employee = getEmployee(employeeForm);
        // luu vao db
        employeeRepository.save(employee);

    }

    @Override
    public Page<Employee> findAllByNameContaining(String name, Pageable pageable) {
        return employeeRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public Employee getEmployee(EmployeeForm employeeForm) {
        // lay ten file
        MultipartFile multipartFile = employeeForm.getAvatar();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("file_upload").toString();
        // luu file len server
        try {
            //multipartFile.transferTo(imageFile);
            FileCopyUtils.copy(employeeForm.getAvatar().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (fileName.equals("") && employeeForm.getId() != null) {
            Employee employee = (Employee) findById(employeeForm.getId());
            fileName = employee.getAvatar();
        }
        // tham khảo: https://github.com/codegym-vn/spring-static-resources

        // tao doi tuong de luu vao db
        if (employeeForm.getId() == null) {
            return new Employee(employeeForm.getName(), employeeForm.getAddress(), fileName, employeeForm.getSalary(), employeeForm.getBirthDate(), employeeForm.getDepartment());
        } else {
            return new Employee(employeeForm.getId(), employeeForm.getName(), employeeForm.getAddress(), fileName, employeeForm.getSalary(), employeeForm.getBirthDate(), employeeForm.getDepartment());
        }
    }


    @Override
    public Page findAll(Pageable pageable) {
        return employeeRepository.sort(pageable);
    }

    @Override
    public void delete(long id) {
        employeeRepository.delete(id);
    }

    @Override
    public Employee findById(long id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }
}

