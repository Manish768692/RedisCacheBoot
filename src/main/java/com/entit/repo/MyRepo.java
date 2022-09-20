package com.entit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entit.modal.Employee;

public interface MyRepo extends JpaRepository<Employee, Integer> {
	
	
}

