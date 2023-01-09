package com.example.employeejpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeejpa.entity.Employee;
import com.example.employeejpa.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
//	List all the employees
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return employeeService.getEmployee();
	} 
	
//	Display Employee By ID
	@GetMapping("/employee/{employeeId}")
	public Employee getEmployeeByID(@PathVariable int employeeId) {
		return employeeService.getEmployeeById(employeeId);
	}
	
//	Add an employee
	@PostMapping("/employee/add")
	public ResponseEntity<String> addEmployee(@RequestBody Employee emp){
		employeeService.addEmployee(emp);
		return new ResponseEntity<String>("Employee added Successfully",HttpStatus.ACCEPTED);
		
	}
	
//	Update an employee
	@PutMapping("/employee/update/{EmployeeID}")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee emp, @PathVariable int EmployeeID){
		if(EmployeeID!=emp.getEmployeeID()) {
			return new ResponseEntity<String>("EmployeeID mismatched...!",HttpStatus.OK);

		}else {
			employeeService.updateEmployee(emp, EmployeeID);
			return new ResponseEntity<String>("Employee Info updated...!",HttpStatus.OK);
		}
		
		
	}
	
//	Delete employee by ID
	@DeleteMapping("/employee/delete/{employeeId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int employeeId){
		employeeService.deleteEmployeeByID(employeeId);
		return new ResponseEntity<String>("Employee with id "+employeeId+" deleted successfully!!",HttpStatus.OK);
	}
}
