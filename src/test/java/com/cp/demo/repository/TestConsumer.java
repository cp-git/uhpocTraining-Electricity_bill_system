package com.cp.demo.repository;

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
import com.cp.demo.exception.CPException;
import com.cp.demo.service.ConsumerService;
import com.cp.demo.serviceimpl.ConsumerServiceImpl;


public class TestConsumer {
	
	private static ConsumerRepository consumerRepo;
	private static ConsumerService conumerService;
	static HashMap<Integer,Consumer> ConsumerCache=null;
	static DBManager dbm=null;
	static Connection con = null;
	static List<Consumer> consList = null;
	List<Consumer> consumerList = null;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before");
		consumerRepo = new ConsumerRepository();
		conumerService = new ConsumerServiceImpl();
		ConsumerCache = new HashMap<>();
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
	

	@After
	public void tearDown() throws Exception {
		dbm.closeConnection(con);
	}

	
	@Test
	
	public void getlastConsumerId()
	{
		Consumer consumer=new Consumer(83,"abhi",3598,"kharadi","kharadi","Pune",23,45);
		try {
			int LastConsumerId=consumerRepo.getlastConsumerId();
			consumerList=conumerService.getAllConsumer();
			Consumer cons=consumerList.get(consumerList.size()-1);
			assertEquals(cons.getConsId(),LastConsumerId);
			
		} catch (CPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	@Test
	public void  getConsumerById()
	{
		Consumer  consDetails=consumerRepo.getConsumerById(83);
		assertEquals("anu",consDetails.getConsName());
		assertEquals(9898,consDetails.getConsNumber());
		
	}
	
	
	@Test
	public void initialConsumerCache() {
		
		Consumer consData= new Consumer(83, "anu", 9898, "katraj", "katraj", "pune",673,57);

		HashMap<Integer, Consumer> custCache = conumerService.display();
		Consumer cons = custCache.get(9898);
		assertEquals(consData.getConsName(), cons.getConsName());
		assertEquals(consData.getConsId(),cons.getConsId());
		assertEquals(consData.getConsCity(),cons.getConsCity());
	
		
		
	}
	

}
