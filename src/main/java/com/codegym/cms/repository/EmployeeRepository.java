package com.codegym.cms.repository;
import com.codegym.cms.model.Department;
import com.codegym.cms.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e ORDER BY e.name asc ")

    Page<Employee> sort(Pageable pageable);


    Page<Employee> findAllByNameContaining(String firstname, Pageable pageable);
    Iterable<Employee>findAllByDepartment(Department department);
}
