package com.cp.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.cp.demo.dbhelper.DBManager;
import com.cp.demo.entity.Consumer;
import com.cp.demo.entity.Department;
import com.cp.demo.entity.Power;
import com.cp.demo.exception.CPException;
import com.cp.demo.service.ConsumerService;
import com.cp.demo.service.DepartmentService;
import com.cp.demo.service.PowerService;
import com.cp.demo.serviceimpl.ConsumerServiceImpl;
import com.cp.demo.serviceimpl.DepartmentServiceImpl;
import com.cp.demo.serviceimpl.PowerServiceImpl;

public class MainMenu {

	private static HashMap<String, Department> DepartmentCache = new HashMap<String, Department>();
	private static HashMap<Integer, Consumer> ConsumerCache = new HashMap<>();
	private static HashMap<Integer, Power> billCache = new HashMap<>();

	public MainMenu() {
//		initCache();
	}

	private static void loadCache() {
		DepartmentService deptService = new DepartmentServiceImpl();
		DepartmentCache = deptService.display();

		ConsumerService consumerService = new ConsumerServiceImpl();
		ConsumerCache = consumerService.display();
		
		PowerService pwService=new PowerServiceImpl();
		billCache=pwService.display();
	//	System.out.println(billCache);

	}

	public static void main(String[] args) throws CPException, ParseException {

		if ((DepartmentCache != null || DepartmentCache.size() == 0) ||(ConsumerCache!=null || ConsumerCache.size()==0)||(billCache!=null || billCache.size()==0)) {
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
				DepartmentService deptService = new DepartmentServiceImpl();
				if (DepartmentCache.isEmpty() || DepartmentCache.size() == 0) {
					System.out.println("Enter the Department Name");
					String deptName = sc1.next();
			
					System.out.println("Enter the Department City");
					String deptCity = sc1.next();
					
					System.out.println("Enter the Department State");
					String deptState = sc1.next();
					

					Department department = new Department(deptName, deptCity, deptState);
					int deptId = deptService.createDepartment(department);
					department.setDeptId(deptId);

					deptService.getAllDepartment();
					DepartmentCache.put(department.getDeptName(), department);
				} else {
					System.out.println("Data is already exists..");
				}

				break;
			case 2:
				int consId = 0;
				int deptId = 0;
				ConsumerService consumerService = new ConsumerServiceImpl();
				while (true) {
					try {
						System.out.println("Enter the Consumer Name");
						String consName = sc1.next();
						
						System.out.println("Enter the Consumer Number");
						int consNumber = sc1.nextInt();
						

						System.out.println("Enter the Consumer Address1");
						String consAddress1 = sc1.next();

						System.out.println("Enter the Consumer Address2");
						String consAddress2 = sc1.next();
						System.out.println("Enter the Consumer city");
						String consCity = sc1.next();
						System.out.println("Enter the Consumer phone");
						int consPhone = sc1.nextInt();

						if (ConsumerCache.containsKey(consNumber)) {
							System.out.println("Consumer number already exist..");
						}

						else {
							Department dept = null;
							for (String deptName : DepartmentCache.keySet()) {
								dept = DepartmentCache.get(deptName);
								deptId = DepartmentCache.get(deptName).getDeptId();
								System.out.println(deptId);

							}

							Consumer consumer = new Consumer(consName, consNumber, consAddress1, consAddress2, consCity,
									consPhone, deptId);
							consId = consumerService.createConsumer(consumer);
							consumer.setConsId(consId);
							ConsumerCache.put(consNumber, consumer);
							System.out.println("Consumer is Successfully inserted....");

						}

					} catch (Exception ee) {
						ee.printStackTrace();
						break;
					}

					System.out.println("Do you want to add anothr consumer Yes[Y] or No[N]?\n press any for main menu");
					String ch = sc1.next();
					sc1.nextLine();
					if (ch.equals("Y") || ch.equals("y")) {
						continue;
					} else {
						break;
					}

				} // while loop

				break;

			case 3:
				PowerService powerService=new PowerServiceImpl();
				
			consId=0;
			int consNumber=0;
			List<Power> listInvProd = null;
			List<Power> listPower=null;
			String dateAfter = null;
			SimpleDateFormat formatter1 = null;
			Consumer consumer = null;
			 Calendar cal = null;
			 
				Map<String,List<String>> map = null;
				 List<String> list = null;
			
			while(true) {
				
				try {
				System.out.println("Enter the Consumer Number");
				 consNumber=sc1.nextInt();
				
				if(ConsumerCache.containsKey(consNumber))
				{
					System.out.println("Already Exist...");
					consId=ConsumerCache.get(consNumber).getConsId();
					System.out.println(consId);
					
				}
				System.out.println("Enter the Date:");
				String readingDate=sc1.next();
				   formatter1=new SimpleDateFormat("dd/MM/yyyy");
				  Date date1=formatter1.parse(readingDate);
				
				System.out.println("Enter the CMR");
				int powerCmr=sc1.nextInt();
				
				System.out.println("Enter the Reader Name");
				String readerName=sc1.next();
				
				Power power=new Power(readingDate,powerCmr,readerName,consId);
				int billId=powerService.createBill(power);
				power.setBillId(billId);
				billCache.put(power.getBillId(), power);
				
				
				
				    cal = Calendar.getInstance();  
			        try{  
			           cal.setTime(formatter1.parse(readingDate));  
			        }catch(ParseException e){  
			            e.printStackTrace();  
			         }  
			        
			        cal.add(Calendar.DAY_OF_MONTH, 30);  
			        dateAfter = formatter1.format(cal.getTime());  
			        //System.out.println(dateAfter+" is the date after adding 30 days.");  
			        
			       
			       
			       
			        

				
			        
				
				/*Department dept = null;
				for (String deptName : DepartmentCache.keySet()) {
					dept = DepartmentCache.get(deptName);
					deptId = DepartmentCache.get(deptName).getDeptId();
					System.out.println(deptId);
				}
				//printing the Department Details
				System.out.println("Department ID"+dept.getDeptId()+
						"\n Department Name:"+dept.getDeptName()+
						"\n Department City"+dept.getDeptCity()+
						"\n Department State"+dept.getDeptState());
				
				System.out.println(ConsumerCache.get(consNumber));
				//System.out.println(billCache.get(consId));*/
				
				
				//Printing the data
			 listInvProd = powerService.getBillGeneration(consId);
				//System.out.println(listInvProd);
				
			consumerService=new ConsumerServiceImpl();
			
			 consumer=consumerService.getProductById(consId);
			 
			 
			 
			 
			 
			
			
				
				
			}
			catch(Exception tt) {
				tt.printStackTrace();
				break;
			}
				
				System.out.println("Do you want to add anothr Bill Yes[Y] or No[N]?\n press any for main menu");
				String ch1 = sc1.next();
				sc1.nextLine();
				if (ch1.equals("Y") || ch1.equals("y")) {
					continue;
				} else {
					break;
				}
				
				
			}
			
			Department dept = null;
			for (String deptName : DepartmentCache.keySet()) {
				dept = DepartmentCache.get(deptName);
				deptId = DepartmentCache.get(deptName).getDeptId();
				//System.out.println(deptId);
			}
			//printing the Department Details
			System.out.println("                   "+dept.getDeptName());
			System.out.println("\n                  "+dept.getDeptCity()+"\t -"+dept.getDeptState());
			
				
				//System.out.println(ConsumerCache.get(consNumber));
				//System.out.println(listInvProd);
				
				System.out.println(consumer.getConsId());
				System.out.println("Consumer Name        :"+consumer.getConsName());
				System.out.println("Consumer Number      :"+consumer.getConsNumber());
				System.out.println("Consumer Address1    :"+consumer.getConsAddress1());
				System.out.println("Consumer Address     :"+consumer.getConsAddress2());
				System.out.println("Consumer City        :"+consumer.getConsCity());
				
				
				
				System.out.println("Reading Date \t power cmr \t Reader Name \t Due Date");
				for(Power pp:listInvProd)
				{
					

					try{  
				           cal.setTime(formatter1.parse(pp.getReadingDate()));  
				        }catch(ParseException e){  
				            e.printStackTrace();  
				         }  
				        
				        cal.add(Calendar.DAY_OF_MONTH, 31);  
				        dateAfter = formatter1.format(cal.getTime());  
					
					
					
					System.out.println(pp.getReadingDate()+"          "+pp.getPowerCmr()+"           "+pp.getReaderName()+"          "+dateAfter);
				
					
					//System.out.println(dateAfter);
					
					
					
				
					
				}
				
			
				
				
				
			
				
				//System.out.println(listPower.);
				
				
				
			
				
				
				
				
		
				
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
