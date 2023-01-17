package com.example.training.manageemployees;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	private static List<Employee> employeeDatabase = new ArrayList<Employee>();
	static {
		Employee james = new Employee();
		james.setEmpId(100);
		james.setEmpName("James Cooper");
		Employee steven = new Employee();
		steven.setEmpId(200);
		steven.setEmpName("Steven King");
		employeeDatabase.add(james);
		employeeDatabase.add(steven);
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeDatabase;
	}
	
	@GetMapping("/employees/{paramEmpId}")
	public Employee getEmployee(@PathVariable("paramEmpId") Integer paramEmpId) {
		for(Employee emp : employeeDatabase) {
			if(emp.getEmpId().intValue() == paramEmpId.intValue())
				return emp;
		}
		return null;
	}
}
