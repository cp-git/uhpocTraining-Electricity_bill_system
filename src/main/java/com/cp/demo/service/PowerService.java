package com.cp.demo.service;

import java.util.HashMap;
import java.util.List;

import com.cp.demo.entity.Consumer;
import com.cp.demo.entity.Power;

public interface PowerService {
	
	int createBill(Power power);
	public List<Power> getAllPowerDetails();
	
	HashMap<Integer,Power> display();
	
	public Power getPowerBillById(int billId);
	
	public List<Power> getBillGeneration(int consId);
	
	
	

	
	
	
	
	
	
	

}
