package com.entit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entit.modal.Employee;
import com.entit.service.MyService;

@Controller
@RequestMapping("/employee")
public class MyController {
	
	@Autowired
	private MyService service;
	
	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee e) {
		return service.saveEmployee(e);	
	}
	
	@GetMapping("/delete/{empId}")
	public String deleteEmployee(@PathVariable Integer empId) {
		service.deleteEmployee(empId);
		return "Employee Deleted "+ empId;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		return ResponseEntity.ok(service.getAllEmployee());
	}
	
	@GetMapping("/one/{empId}")
	public Employee getOneEmployee(@PathVariable Integer empId) {
		return service.getOneEmployee(empId);
	}
	
	@PutMapping("/modify/{empId}")
	public Employee updateEmployee(@PathVariable Integer empId, @RequestBody Employee e) {
		Employee e1 = service.updateEmployee(empId, e);
		return e1;
}

}