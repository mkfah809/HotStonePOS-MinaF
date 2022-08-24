package com.coderscampus.HotStonePOS.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.coderscampus.HotStonePOS.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//	select e from Employee e left join authorities on a.employee_emp_id = e.emp_id;
//	@Query("select e"
//			+ " from Employee, Authority a"
//			+ " where ")
//	@Query("select e from Employe e"
//			+ " left join fetch authority"
//			+ " where u.empUsername = :username")
	@Query("select e from Employee e"
			+ " left join fetch e.authorities "
			+ "where e.empUsername = :username") 
	Employee findByEmpUsername(@Param(value = "username") String username);
}
