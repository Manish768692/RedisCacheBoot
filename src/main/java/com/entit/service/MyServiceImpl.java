package com.entit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entit.exception.ResourseNotFoundException;
import com.entit.modal.Employee;
import com.entit.repo.MyRepo;

@Service
public class MyServiceImpl implements MyService{

	@Autowired
	private MyRepo repo;
	
	@Override
	public Employee saveEmployee(Employee e) {
		return repo.save(e);	
	}

	@Override
	public Employee updateEmployee(Integer empId, Employee e) {
	Employee emp = repo.findById(empId)
					.orElseThrow( ()-> new ResourseNotFoundException("Employee Not Found") );
	emp.setEmpName(e.getEmpName());
	emp.setEmpSal(e.getEmpSal());
	return repo.save(e);
	}

	@Override
	public void deleteEmployee(Integer empId) {
	Employee e = repo.findById(empId)
			.orElseThrow( () ->new ResourseNotFoundException("Employee Not Found del"));
	repo.delete(e);
	}

	@Override
	public Employee getOneEmployee(Integer empId) {
		Employee emp = repo.findById(empId)
				.orElseThrow( () ->new ResourseNotFoundException("Employee Not Found getOneEmployee"));
		return emp;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return repo.findAll();
	}
	
}

