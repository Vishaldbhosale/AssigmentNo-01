package com.javatechie.crud.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javatechie.crud.example.entity.Employee;
import com.javatechie.crud.example.repository.EmployeeRepository;


@Service
public class EmployeeService  {
	
	@Autowired
	private EmployeeRepository repository;
	
	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
		
	}
	
	public List<Employee>saveEmployee(List<Employee>employee){
		return (List<Employee>) repository.saveAll(employee);
		
	}

	public List<Employee>getEmployee(){
		return (List<Employee>) repository.findAll();
	}
	
	public Employee getEmployeeById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	
	public String deleteEmployee(int id) {
		repository.deleteById(id);
		return "Product Removed!!"+id;
	}
	
	public Employee updateEmployee(Employee employee) {
		Employee existingProduct=repository.findById(employee.getEmpId()).orElse(null);  //fetch existing product avalable in db
		existingProduct.setEmpId(employee.getEmpId());
	    existingProduct.setSalary(employee.getSalary());
	    existingProduct.setDesignation(employee.getDesignation());
	    
		return repository.save(existingProduct);
	}
	
//   public List<Employee> findByDesignation(String designation) {     //need to customize your query
//		
//		return repository.findByDesignation(designation);
//	}

}
