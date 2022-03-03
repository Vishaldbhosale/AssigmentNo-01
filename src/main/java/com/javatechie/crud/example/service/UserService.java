package com.javatechie.crud.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javatechie.crud.example.entity.User;
import com.javatechie.crud.example.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired                                //Inject UserRepository into UserService, UserService will talk to UserRepository
	private UserRepository repository;               
	
	public User saveUser(User user) {		  //Save User Object to database(saveUser are post methods)
		return repository.save(user);         
		
	}
	
	public List<User>saveUser(List<User>user){
		return (List<User>) repository.saveAll(user);
		
	}

	public List<User>getUser(){                   // fetch all User
		return (List<User>) repository.findAll();
	}
	
	public User getUserById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public String deleteUser(int id) {            // delete User by id
		repository.deleteById(id);
		return "Product Removed Succesfully"+id;
	}
	
	public User updateUser(User user) {           //update User
		User existingProduct=repository.findById(user.getId()).orElse(null);  //fetch existing product avalable in db
		existingProduct.setId(user.getId());
	    existingProduct.setFirstName(user.getFirstName());
	    existingProduct.setLastName(user.getLastName());
	    existingProduct.setContact(user.getContact());
	    existingProduct.setAddress(user.getAddress());
	    existingProduct.setJob(user.getJob());
	    existingProduct.setRole(user.getRole());
	    existingProduct.setStatus(user.isStatus());
	   
	   
		return repository.save(existingProduct);
	}

	public List<User> findByLastName(String lastName) {     //need to customize your query
		
		return repository.findByLastName(lastName);
	}

	

}

