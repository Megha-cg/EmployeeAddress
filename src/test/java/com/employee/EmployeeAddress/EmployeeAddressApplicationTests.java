package com.employee.EmployeeAddress;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.employee.EmployeeAddress.Dao.EmployeeAddressDao;
import com.employee.EmployeeAddress.Model.EmployeeAddressModel;
import com.employee.EmployeeAddress.Service.EmployeeAddressServiceImpl;

@SpringBootTest
class EmployeeAddressApplicationTests {

    @MockBean
	private EmployeeAddressDao repository;
    @MockBean
	private EmployeeAddressServiceImpl serviceNew;
    @Test
	public void getallempTest() {
    List<Map> al = new LinkedList<Map>();
    Map<String,Object> map = new LinkedHashMap<String,Object>();
	map.put("id", 3);
	map.put("name", "Megha");
	map.put("role", "devloper");
	map.put("address", "RK road Delhi India");

	Map<String,Object> map2 = new LinkedHashMap<String,Object>();
	map2.put("id", 4);
	map2.put("name", "Pooja");
	map2.put("role", "devloper");
	map2.put("address", "Narhe Pune India");

	al.add(map);
	al.add(map2);
    when(serviceNew.getAllEmployee()).thenReturn(al);
	assertEquals(2,serviceNew.getAllEmployee().size());
 }

    @Test
	public void addEmpTest() {
    EmployeeAddressModel employee = new EmployeeAddressModel(3,"Megha","devloper","RK society","Delhi","India");
    Map<String,Object> map = new LinkedHashMap<String,Object>();
	map.put("id", employee.getId());
	map.put("name", employee.getName());
	map.put("role", employee.getRole());
	map.put("address", employee.getAddressOne()+employee.getAddressTwo()+employee.getAddressThree());
    when(serviceNew.addEmployee(employee)).thenReturn(map);
	assertEquals(map,serviceNew.addEmployee(employee));
 }
    @Test
	public void updateTest() {
    EmployeeAddressModel emp = new EmployeeAddressModel(15,"Jack","tester","MJ road","America","UK");
	when(serviceNew.updateEmployee(emp)).thenReturn(emp);
	assertEquals(emp,serviceNew.updateEmployee(emp));
 }
    @Test
	public void deleteTest() {
    EmployeeAddressModel employee = new EmployeeAddressModel(5,"Neha","devloper","Narhe","Pune","India");
    when(repository.deleteEmp(5)).thenReturn(true);
	assertFalse(serviceNew.deleteempById(5));
 }
}