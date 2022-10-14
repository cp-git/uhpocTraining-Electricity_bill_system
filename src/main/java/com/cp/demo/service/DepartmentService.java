package com.cp.demo.service;

import java.util.HashMap;
import java.util.List;

import com.cp.demo.entity.Department;

public interface DepartmentService {
	
	int createDepartment(Department department);
	 List<Department> getAllDepartment();
	 HashMap<String, Department> display();
}
