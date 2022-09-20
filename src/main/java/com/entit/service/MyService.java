package com.entit.service;

import java.util.List;

import com.entit.modal.Employee;

public interface MyService {
	
	Employee saveEmployee(Employee e);
	Employee updateEmployee(Integer empId, Employee e);
	void deleteEmployee(Integer empId);
	Employee getOneEmployee(Integer empId);
	List<Employee> getAllEmployee();
}

