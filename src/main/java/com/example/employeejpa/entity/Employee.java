package com.example.employeejpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	private int employeeID;
	private String name;
	private String designation;
	private int salary;
	public Employee() {
	}
	
	public Employee(int employeeID, String name, String designation, int salary) {
		this.employeeID = employeeID;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", name=" + name + ", designation=" + designation + ", salary="
				+ salary + "]";
	}
	
	
}
