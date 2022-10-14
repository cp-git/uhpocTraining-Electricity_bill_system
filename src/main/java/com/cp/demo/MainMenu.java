package com.cp.demo;

import java.util.HashMap;
import java.util.Scanner;

import com.cp.demo.contoller.DemoController;
import com.cp.demo.entity.Department;
import com.cp.demo.exception.CPException;
import com.cp.demo.service.DepartmentService;
import com.cp.demo.serviceimpl.DepartmentServiceImpl;
import com.cp.inv.util.DBManager;

public class MainMenu {
	
	private static HashMap<String,Department> DepartmentCache=new HashMap<String,Department>();

	public MainMenu() {
//		initCache();
	}
	
	private static void loadCache() {
		DepartmentService deptService=new DepartmentServiceImpl();
		DepartmentCache=deptService.display();
		
	}

	public static void main(String[] args) throws CPException {
		
		if((DepartmentCache !=null || DepartmentCache.size()==0)){
			loadCache();
		}

		while (true) {
			System.out.println("============= Main Menu ============");
			System.out.println("1. Create Department Store");
			System.out.println("2. Add New Consumer");
			System.out.println("3. Generate Electrcity Bill");
			System.out.println("4. Exit");
			Scanner sc1 = new Scanner(System.in);
			int option = sc1.nextInt();
			switch (option) {
			case 1:
				DepartmentService deptService=new DepartmentServiceImpl();
				if(DepartmentCache.isEmpty() || DepartmentCache.size()==0) {
				System.out.println("Enter the Department Name");
				String deptName=sc1.next();
				System.out.println("Enter the Department City");
				String deptCity=sc1.next();
				System.out.println("Enter the Department State");
				String deptState=sc1.next();
				
				Department department=new Department(deptName,deptCity,deptState);
				int deptId=deptService.createDepartment(department);
				department.setDeptId(deptId);
				
				deptService.getAllDepartment();
				DepartmentCache.put(department.getDeptName(), department);
				}
				else {
					System.out.println("Data is already exists..");
				}
				
				
				
				break;
			case 2:
				
				break;
				

			case 3:
				break;
			case 4:
				DBManager dbm = DBManager.getDBManager();
				dbm.cleanPool();
				sc1.close();
				System.exit(0);
				break;
			case 5:
				System.out.println("Please enter options between 1 to 4 ");
				break;
			}
		}

	}

}
