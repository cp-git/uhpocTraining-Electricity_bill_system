package com.cp.demo.ServiceImpl;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cp.demo.dbhelper.DBManager;
import com.cp.demo.entity.Consumer;
import com.cp.demo.service.ConsumerService;
import com.cp.demo.serviceimpl.ConsumerServiceImpl;



public class TestConsumerServiceImpl {
	

	private static ConsumerService consService = null;
	static HashMap<Integer, Consumer> consumerCache = null;
	static DBManager dbm = null;
	static Connection con = null;
	static List<Consumer> consList = null;
	List<Consumer> conList = null;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before");
		consService = new ConsumerServiceImpl();
		consumerCache = new HashMap<>();
		dbm = DBManager.getDBManager();
		consList = new ArrayList<>();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		con=dbm.getConnection();
	}
	
	
	@Test
	public void testGetCustomerDetails() {
		Consumer expCons = new Consumer(83, "Anmesh", 3598, "solapur", "katraj", "Solapur",673,57);

		conList = consService.getAllConsumer();

		Consumer cons = conList.get(0);
		assertEquals(expCons.getConsName(), cons.getConsName());
		assertEquals(expCons.getConsCity(), cons.getConsCity());


	}
	
	@Test
	public void testInitializeCustomerCache() {
		Consumer expCons = new Consumer(84, "anuja", 9898, "katraj", "katraj", "pune",123456,57);

		HashMap<Integer, Consumer> consCache = consService.display();
		Consumer consumer = consCache.get(9898);
		assertEquals(expCons.getConsName(), consumer.getConsName());


	}

	
	
	

	@After
	public void tearDown() throws Exception {
		dbm.closeConnection(con);
	}


}
