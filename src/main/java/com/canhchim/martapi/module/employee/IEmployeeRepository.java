package com.canhchim.martapi.module.employee;

import com.canhchim.martapi.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("select e from Employee e where upper(e.username) like upper(?1)")
    Employee findByUsernameLikeIgnoreCase(String username);

    @Query("select e from Employee e where e.id = ?1")
    @Override
    Optional<Employee> findById(Long integer);
}