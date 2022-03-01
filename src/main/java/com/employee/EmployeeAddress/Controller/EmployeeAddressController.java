package com.employee.EmployeeAddress.Controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.employee.EmployeeAddress.Model.EmployeeAddressModel;
import com.employee.EmployeeAddress.Service.EmployeeAddressServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
public class EmployeeAddressController {
     Logger logger = LoggerFactory.getLogger(EmployeeAddressController.class);
     @Autowired
	EmployeeAddressServiceImpl service;
		
			// add new employee	
		@PostMapping("/addemp")  
		public Map<String,Object> addEmployees(@RequestBody EmployeeAddressModel employee){
			return service.addEmployee(employee);
			}
		
		// get all employee
		@GetMapping("/allemp")
		public List<Map> getAllEmployees1()
		  {
			 logger.trace("A TRACE Message");
			 logger.error("An ERROR Message");
		   return service.getAllEmployee();
		  } 
		
		//update employee details
		@PutMapping("/update")
		public EmployeeAddressModel updateAccount(@RequestBody EmployeeAddressModel account) {
		EmployeeAddressModel emp = service.updateEmployee(account);
		logger.info("Employee Data is here");
		logger.info("Employee ID: " + emp.getId() + " || Employee Name: " + emp.getName() + " || Employee Role: " + emp.getRole());
		return emp;
		}
		
		//delete employee by id
		@DeleteMapping("/removeemp/{id}")
		  public Boolean delete(@PathVariable int id) {
			 logger.info("An INFO Message");
			return service.deleteempById(id);   //@return employee list after delete by id
		  }
	}


