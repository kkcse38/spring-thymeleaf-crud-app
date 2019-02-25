package com.dcode.springboot.thymeleafdemoproject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcode.springboot.thymeleafdemoproject.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// Custom sort method
	public List<Employee> findAllByOrderByFirstNameAsc();
}
