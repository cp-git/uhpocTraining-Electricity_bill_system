package com.cp.demo;

import java.util.HashMap;
import java.util.Scanner;

import com.cp.demo.contoller.DemoController;
import com.cp.demo.entity.Consumer;
import com.cp.demo.entity.Department;
import com.cp.demo.exception.CPException;
import com.cp.demo.service.ConsumerService;
import com.cp.demo.service.DepartmentService;
import com.cp.demo.serviceimpl.ConsumerServiceImpl;
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
				int consId=0;
				int deptId = 0;
				ConsumerService consumerService=new ConsumerServiceImpl();
				
				System.out.println("Enter the Consumer Name");
				String consName=sc1.next();
				
				System.out.println("Enter the Consumer Number");
				int consNumber=sc1.nextInt();
				
				System.out.println("Enter the Consumer Address1");
				String consAddress1=sc1.next();
				
				System.out.println("Enter the Consumer Address2");
				String consAddress2=sc1.next();
				System.out.println("Enter the Consumer city");
				String consCity=sc1.next();
				System.out.println("Enter the Consumer phone");
				int consPhone=sc1.nextInt();
				
				Department dept=null;
				for(String deptName:DepartmentCache.keySet()) {
					dept=DepartmentCache.get(deptName);
					deptId=DepartmentCache.get(deptName).getDeptId();
					System.out.println(deptId);
					
				}
				
				Consumer consumer=new Consumer(consName,consNumber,consAddress1,consAddress2,consCity,consPhone,deptId);
				consId = consumerService.createConsumer(consumer);
				consumer.setConsId(consId);
				
				consumerService.getAllConsumer();
				
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
