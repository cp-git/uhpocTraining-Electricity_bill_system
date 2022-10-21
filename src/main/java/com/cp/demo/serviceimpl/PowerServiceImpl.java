package com.cp.demo.serviceimpl;

import java.util.HashMap;
import java.util.List;

import com.cp.demo.entity.Power;
import com.cp.demo.repository.PowerRepo;
import com.cp.demo.service.PowerService;

public class PowerServiceImpl implements PowerService {
	HashMap<Integer,Power> billCache=new HashMap<Integer,Power>();

	PowerRepo powerRepo=new PowerRepo();
	public int createBill(Power power) {
		int billId=0;
		try {
			billId=powerRepo.createpowerbill(power);
			
		}
		catch(Exception ee) {
			ee.printStackTrace();
		}
		// TODO Auto-generated method stub
		return billId;
	}
	@Override
	public List<Power> getAllPowerDetails() {
		// TODO Auto-generated method stub
		return powerRepo.getDetailsPower();
	}
	@Override
	public HashMap<Integer, Power> display() {
		// TODO Auto-generated method stub
		for(Power pw:powerRepo.getDetailsPower()) {
			billCache.put(pw.getBillId(), pw);
			
		}
		//System.out.println("Billcache Data is.."+billCache);
		return billCache;
	}
	@Override
	public Power getPowerBillById(int billId) {
		// TODO Auto-generated method stub
		return powerRepo.getConsumerById(billId);
	}
	@Override
	public List<Power> getBillGeneration(int consId) {
		// TODO Auto-generated method stub
		List<Power> listProdList = powerRepo.getListPowerDetails(consId);
		return listProdList;
	}
	
	
	

}
