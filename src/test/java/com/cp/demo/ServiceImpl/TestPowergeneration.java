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
import com.cp.demo.entity.Consumer;
import com.cp.demo.entity.Power;
import com.cp.demo.repository.PowerRepo;
import com.cp.demo.service.PowerService;
import com.cp.demo.serviceimpl.PowerServiceImpl;

public class TestPowergeneration {
	
	static PowerRepo powerRepo = null;
	static PowerService powerService = null;
	static HashMap<Integer, Power> bCache ;
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
	
	public void testList() {
		Power expCons = new Power(223, "09/02/2021", 90, "abv", 85);

		List<Power> checkList=new ArrayList<>();
		checkList = powerService.getAllPowerDetails();

		Power pow = checkList.get(0);
		assertEquals(expCons.getPowerCmr(),pow.getPowerCmr());
	//	assertEquals(expCons.getConsCity(), cons.getConsCity());

	}
	
	
	
	@Test
	public void testInitializePowerCache() {
		
		Power pwcons = new Power(223, "09/02/2021", 90, "abv", 85);

		HashMap<Integer, Power> bCache = powerService.display();
		System.out.println(bCache);
		Power pwo = bCache.get(223);
		System.out.println(pwo);
		assertEquals(pwcons.getBillId(), pwo.getBillId());
		assertEquals(pwcons.getPowerCmr(), pwo.getPowerCmr());


	}
	@After
	public void tearDown() throws Exception {
		dbm.closeConnection(con);
	}

	

}
