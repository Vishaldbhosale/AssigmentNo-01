package com.javatechie.crud.example.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.javatechie.crud.example.entity.Employee;



public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

//	List<Employee>findByDesignation(String designation);
}
