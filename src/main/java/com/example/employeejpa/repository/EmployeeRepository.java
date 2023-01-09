package com.example.employeejpa.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.employeejpa.entity.Employee;
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

	@Modifying
	@Query("update Employee set name=?1, designation=?2, salary=?3 where employeeID=?4")
	public void updateEmployee(String name, String designation, int salary,int employeeID);
}
