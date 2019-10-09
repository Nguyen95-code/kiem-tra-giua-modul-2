package com.codegym.cms.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

public class EmployeeForm {
    private Long id;
    private String name;
    private String address;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;
    private MultipartFile avatar;
    private float salary;

    public EmployeeForm() {
    }

    public Department department;

    public EmployeeForm(Long id, String name, String address, LocalDate birthDate, MultipartFile avatar, float salary, Department department) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.birthDate = birthDate;
        this.avatar = avatar;
        this.salary = salary;
        this.department = department;
    }

    public EmployeeForm(String name, String address, LocalDate birthDate, MultipartFile avatar, float salary, Department department) {
        this.name = name;
        this.address = address;
        this.birthDate = birthDate;
        this.avatar = avatar;
        this.salary = salary;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
