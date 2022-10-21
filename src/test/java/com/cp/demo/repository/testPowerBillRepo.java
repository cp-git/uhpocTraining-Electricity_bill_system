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
import com.cp.demo.entity.Power;
import com.cp.demo.service.PowerService;
import com.cp.demo.serviceimpl.PowerServiceImpl;





public class testPowerBillRepo {
	
	static PowerRepo powerRepo = null;
	static PowerService powerService = null;
	static HashMap<Integer, Power> billCache = null;
	static DBManager dbm = null;
	static List<Power> powerList= null;
	Connection con = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.out.println("Before");
		powerRepo = new PowerRepo();
		powerService = new PowerServiceImpl();
		billCache = new HashMap<>();
		dbm = DBManager.getDBManager();
		powerList = new ArrayList<>();
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
	public void testInitializeCallCache() {
		Power p1 = new Power(128,"09/05/2022",89,"abhi",82);
	
		
		
		billCache=powerService.display();
		System.out.println(billCache);
		Power pr=billCache.get("09/05/2022");
		System.out.println(pr);
		
		//assertEquals(pr.getPowerCmr(),p1.getPowerCmr());
		assertEquals(pr.getReaderName(),p1.getReaderName());
	
		
		
		
		
		
		
	}
}
