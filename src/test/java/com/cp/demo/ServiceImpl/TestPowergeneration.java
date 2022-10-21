package com.cp.demo.ServiceImpl;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.Date;
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
import com.cp.demo.repository.PowerRepo;
import com.cp.demo.service.PowerService;
import com.cp.demo.serviceimpl.PowerServiceImpl;

public class TestPowergeneration {
	
	static PowerRepo powerRepo = null;
	static PowerService powerService = null;
	static HashMap<Integer, Power> bCache = null;
	static DBManager dbm = null;
	static HashMap<Integer,Power> powerList= null;
	Connection con = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before");
		powerRepo = new PowerRepo();
		powerService = new PowerServiceImpl();
		bCache = new HashMap<>();
		dbm = DBManager.getDBManager();
		powerList = new HashMap<>();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		con=dbm.getConnection();
	}

	
	@Test
	public void testInitializeCallCache() {
		Power p1 = new Power(128,"09/05/2022",89,"abhi",82);
	
		
		
		bCache=powerService.display();
		System.out.println(bCache);
		Power pr=bCache.get("09/05/2022");
		System.out.println(pr);
		
		//assertEquals(pr.getPowerCmr(),p1.getPowerCmr());
		assertEquals(pr.getReaderName(),p1.getReaderName());
	
		
		
		
		
		
		
	}
	@After
	public void tearDown() throws Exception {
	}

	

}
