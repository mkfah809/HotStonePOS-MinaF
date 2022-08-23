package com.coderscampus.HotStonePOS.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.coderscampus.HotStonePOS.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	
	Employee findByEmpUsername(@Param(value = "username") String username);
}
