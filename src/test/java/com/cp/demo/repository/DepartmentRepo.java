package com.cp.demo.repository;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cp.demo.dbhelper.DBManager;
import com.cp.demo.entity.Department;
import com.cp.demo.service.DepartmentService;
import com.cp.demo.serviceimpl.ConsumerServiceImpl;
import com.cp.demo.serviceimpl.DepartmentServiceImpl;



public class DepartmentRepo {
	
	private static DepartmentRepository departmentRepo;
	private static DepartmentService deptService;
	static HashMap<Integer,Department> DepartmentCache=null;
	static DBManager dbm=null;
	static Connection con = null;
	static List<Department> deptList = null;
	List<Department> departmentList = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before");
		departmentRepo = new DepartmentRepository();
		deptService = new DepartmentServiceImpl();
		DepartmentCache = new HashMap<>();
		dbm = DBManager.getDBManager();
		deptList = new ArrayList<>();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		con=dbm.getConnection();
	}

	@After
	public void tearDown() throws Exception {
	dbm.closeConnection(con);
	}

	
	
	@Test
	public void testData() {
		Department dept=new Department("MSEB","Pune","Mh");
	
		assertEquals("MSEB",dept.getDeptName());
		
		assertEquals("Pune",dept.getDeptCity());
		
		assertEquals("Mh",dept.getDeptState());
		
		
		
	}

	
	
	
	
	

}
