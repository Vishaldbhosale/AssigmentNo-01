package com.javatechie.crud.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.crud.example.entity.Employee;
import com.javatechie.crud.example.entity.User;
import com.javatechie.crud.example.service.EmployeeService;



@RestController
//@RequestMapping("/api/v1/") 
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	
	@PostMapping("employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return this.service.saveEmployee(employee);	
	}
	
	@GetMapping("/employee")
	public List<Employee> findAllEmployee(){
		
		return service.getEmployee();
	}
	
	@GetMapping("/employee/{empId}")
	public Employee findEmployeeById(@PathVariable int empId) {    
		return service.getEmployeeById(empId);
	}
	
	
	@PutMapping("/employee/{id}")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);	
	}
	
	@DeleteMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return service.deleteEmployee(id);
		
	}
	
//	@GetMapping("/employee/{designation}")
//	public ResponseEntity<List<Employee>>getByDesignation(@RequestParam String designation){
//		return new ResponseEntity<List<Employee>>(HttpStatus.OK);
//		
//	}
}
