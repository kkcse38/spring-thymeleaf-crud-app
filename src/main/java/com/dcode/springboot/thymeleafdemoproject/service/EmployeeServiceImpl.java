package com.dcode.springboot.thymeleafdemoproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcode.springboot.thymeleafdemoproject.dao.EmployeeRepository;
import com.dcode.springboot.thymeleafdemoproject.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> sortByFirstName() {
		// TODO Auto-generated method stub
		return employeeRepository.findAllByOrderByFirstNameAsc();
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stu
		Optional<Employee> optional = employeeRepository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}

}
