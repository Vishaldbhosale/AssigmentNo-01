package com.javatechie.crud.example.controller;
import com.javatechie.crud.example.repository.UserRepository;
import com.javatechie.crud.example.service.UserService;

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

import com.javatechie.crud.example.entity.User;


@RestController
//@RequestMapping("/api/v1/")    
public class UserController {

	@Autowired                              //Inject service into Controller class,Controller will talk to the service class
	private UserService service;			
	
	
	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		return this.service.saveUser(user);	
	}
	
	@GetMapping("/user")
	public List<User> findAllUser(){
		
		return service.getUser();
	}
	
	@GetMapping("/user/{id}")
	public User findUserById(@PathVariable int id) {    
		return service.getUserById(id);
	}
	
	
	@PutMapping("/user/{id}")
	public User updateUser(@RequestBody User user) {
		return service.saveUser(user);	
	}
	
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable int id) {
		return service.deleteUser(id);
		
	}
	
	@GetMapping("/user/lastName/{lastName}")
	public ResponseEntity<List<User>>getByFirstName(@RequestParam String lastName){
		return new ResponseEntity<List<User>>(service.findByLastName(lastName),HttpStatus.OK);
		
	}
	
}
