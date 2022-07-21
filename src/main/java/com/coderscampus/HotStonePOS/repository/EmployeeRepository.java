package com.coderscampus.HotStonePOS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderscampus.HotStonePOS.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
