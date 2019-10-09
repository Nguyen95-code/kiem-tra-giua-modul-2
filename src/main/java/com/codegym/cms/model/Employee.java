package com.codegym.cms.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private String avatar;
    private float salary;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;

    public Employee() {
    }

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee(Long id, String name, String address, String avatar, float salary, LocalDate birthDate, Department department) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.avatar = avatar;
        this.salary = salary;
        this.birthDate = birthDate;
        this.department = department;
    }

    public Employee(String name, String address, String avatar, float salary, LocalDate birthDate, Department department) {
        this.name = name;
        this.address = address;
        this.avatar = avatar;
        this.salary = salary;
        this.birthDate = birthDate;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
