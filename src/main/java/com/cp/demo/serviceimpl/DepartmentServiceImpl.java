package com.cp.demo.serviceimpl;

import java.util.HashMap;
import java.util.List;

import com.cp.demo.entity.Department;
import com.cp.demo.repository.DepartmentRepository;
import com.cp.demo.service.DepartmentService;

public class DepartmentServiceImpl  implements DepartmentService{
	
	HashMap<String,Department> DepartmentCache=new HashMap<String,Department>();
	
	DepartmentRepository departmentRepository=new DepartmentRepository();

	public int createDepartment(Department department) {
		int deptId=0;
		try {
			System.out.println("In Service");
			deptId=departmentRepository.insertDepartment(department);
			//System.out.println(deptId);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return deptId;
		// TODO Auto-generated method stub
		
	}

	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		
		return departmentRepository.getdepartmentDetails() ;
	}

	@Override
	public HashMap<String, Department> display() {
		// TODO Auto-generated method stub
		 for(Department dp:departmentRepository.getdepartmentDetails())
		 {
			 DepartmentCache.put(dp.getDeptName(),dp);
			 
		 }
		// System.out.println(DepartmentCache);
		return DepartmentCache ;
	}

}
