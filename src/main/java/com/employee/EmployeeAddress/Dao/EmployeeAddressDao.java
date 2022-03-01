package com.employee.EmployeeAddress.Dao;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.NoRepositoryBean;

import com.employee.EmployeeAddress.Model.EmployeeAddressModel;


public interface EmployeeAddressDao extends JpaRepository<EmployeeAddressModel,Integer> {
		
	public default Boolean deleteEmp(int id){

		Optional<EmployeeAddressModel> emp = findById(id);

		deleteById(id);

		if(emp.isPresent()) {
		return true;
		}
		else {
		return false;
		}
	}
}
	

