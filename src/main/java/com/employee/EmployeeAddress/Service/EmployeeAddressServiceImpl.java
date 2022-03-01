package com.employee.EmployeeAddress.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.EmployeeAddress.Dao.EmployeeAddressDao;
import com.employee.EmployeeAddress.Model.EmployeeAddressModel;
@Service
public class EmployeeAddressServiceImpl implements EmployeeAddressService {
	@Autowired
   EmployeeAddressDao repository;
		//public EmployeeAddressModel addEmployee(EmployeeAddressModel emp) {
   	public Map<String,Object> addEmployee(EmployeeAddressModel emp) {	 
   		repository.save(emp); 
		
		 Map<String, Object> responseEmp = new LinkedHashMap<>();
		 responseEmp.put("id", emp.getId());
		 responseEmp.put("name", emp.getName());
		 responseEmp.put("role", emp.getRole());
		 responseEmp.put("address", emp.getAddressOne()+","+emp.getAddressTwo()+","+emp.getAddressThree());
		return responseEmp;
		} 
		
	public List<Map> getAllEmployee() {
		// TODO Auto-generated method stub
		List<EmployeeAddressModel> empList = new ArrayList<EmployeeAddressModel>();
		List<Map> empNewList = new ArrayList<Map>();
		repository.findAll().forEach(empList :: add);
		for(int i=0; i<empList.size(); i++) { 
			
			EmployeeAddressModel emp = empList.get(i);
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("id", emp.getId());
			map.put("name", emp.getName());
			map.put("role", emp.getRole());
			map.put("address", emp.getAddressOne()+","+emp.getAddressTwo()+","+emp.getAddressThree());
			empNewList.add(map); 
			}
		return empNewList;
		}
   public Boolean deleteempById(int id) {
		return repository.deleteEmp(id);
	}

	public EmployeeAddressModel updateEmployee(EmployeeAddressModel employeeAddressModel) {
		Optional<EmployeeAddressModel> updateacc = repository.findById(employeeAddressModel.getId());
		if(updateacc.isPresent()) {
			repository.saveAndFlush(employeeAddressModel);
   }
		return employeeAddressModel;
		}
 }


