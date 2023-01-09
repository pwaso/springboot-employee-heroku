package com.example.employeejpa.service;

import java.util.List;

import com.example.employeejpa.entity.Employee;

public interface EmployeeService {

	Employee getEmployeeById(int employeeId);
	List<Employee> getEmployee();
	void addEmployee(Employee employee);
	void updateEmployee(Employee updatedEmployee,int employeeId);
	void deleteEmployeeByID(int employeeId);
}
