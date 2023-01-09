package com.example.employeejpa.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeejpa.entity.Employee;
import com.example.employeejpa.exception.EmployeeNotFoundException;
import com.example.employeejpa.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee getEmployeeById(int employeeId) {
		Optional<Employee> empOpt= employeeRepository.findById(employeeId);
		if(!empOpt.isPresent()) {
			throw new EmployeeNotFoundException("Employee with EmployeeID "+employeeId+" not Found!");
		}
		return empOpt.get();
	}

	@Override
	public List<Employee> getEmployee() {
		// TODO Auto-generated method stub
		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
		
	}
	@Transactional
	@Override
	public void updateEmployee(Employee updatedEmployee, int employeeId) {
		employeeRepository.updateEmployee(updatedEmployee.getName(), updatedEmployee.getDesignation(), updatedEmployee.getSalary(), updatedEmployee.getEmployeeID());
		
	}

	@Override
	public void deleteEmployeeByID(int employeeId) {
		employeeRepository.deleteById(employeeId);
		
	}

}
