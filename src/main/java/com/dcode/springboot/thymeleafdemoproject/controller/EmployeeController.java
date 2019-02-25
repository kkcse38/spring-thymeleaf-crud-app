package com.dcode.springboot.thymeleafdemoproject.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dcode.springboot.thymeleafdemoproject.dao.EmployeeRepository;
import com.dcode.springboot.thymeleafdemoproject.entity.Employee;
import com.dcode.springboot.thymeleafdemoproject.service.EmployeeService;
import com.dcode.springboot.thymeleafdemoproject.service.EmployeeServiceImpl;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	List<Employee> list;

	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("currentDate", new Date());
		return "hello";
	}

	@PostConstruct
	public void createEmployeeList() {
		list = new ArrayList<Employee>();

		Employee e1 = new Employee("K", "Kumar", "k@gmail.com");
		Employee e2 = new Employee("P", "Kumari", "p@gmail.com");
		Employee e3 = new Employee("M", "Kumar", "m@gmail.com");
		Employee e4 = new Employee("Q", "Kumari", "q@gmail.com");

		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);

		employeeService.save(e1);
		employeeService.save(e2);
		employeeService.save(e3);
		employeeService.save(e4);
	}

	@GetMapping("/list")
	public String findAllEmployee(Model myModel) {
		myModel.addAttribute("employeeList", employeeService.sortByFirstName());
		return "/employees/index";
	}

	@PostMapping("/save-employee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {

		System.out.println("Employee " + employee.getFirstName());
		// save the employee
		employeeService.save(employee);

		// redirect to employee list
		return "redirect:/employee/list";
	}

	@GetMapping("/employee-form")
	public String displayEmployeeForm(Model theModel) {

		Employee theEmployee = new Employee();

		theModel.addAttribute("employee", theEmployee);

		return "/employees/employee-form";
	}

	@GetMapping("/employee-form-update")
	public String displayEmployeeForm(@RequestParam("employeeId") int id, Model theModel) {

		theModel.addAttribute("employee", employeeService.findById(id));

		return "/employees/employee-form";
	}

	@GetMapping("/employee-delete")
	public String deleteEmployee(@RequestParam("employeeId") int id) {

		// delete the employee
		employeeService.deleteEmployee(id);

		// launch to employeeList
		return "redirect:/employee/list";
	}
}
