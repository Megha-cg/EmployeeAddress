package com.employee.EmployeeAddress.Service;
import java.util.List;
import java.util.Map;
import com.employee.EmployeeAddress.Model.EmployeeAddressModel;
public interface EmployeeAddressService  {
	  
	Map<String,Object> addEmployee(EmployeeAddressModel emp);
	List<Map> getAllEmployee();
	EmployeeAddressModel updateEmployee(EmployeeAddressModel emp);
	Boolean deleteempById(int id);
}