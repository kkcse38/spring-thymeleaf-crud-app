package com.dcode.springboot.thymeleafdemoproject.service;

import java.util.List;

import com.dcode.springboot.thymeleafdemoproject.entity.Employee;

public interface EmployeeService {
	
	public void save(Employee employee);

	public List<Employee> findAll();

	public List<Employee> sortByFirstName();

	public Employee findById(int id);

	public void deleteEmployee(int id);

}
