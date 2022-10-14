package com.cp.demo.serviceimpl;

import java.util.HashMap;
import java.util.List;

import com.cp.demo.entity.Consumer;
import com.cp.demo.repository.ConsumerRepository;
import com.cp.demo.service.ConsumerService;

public class ConsumerServiceImpl implements ConsumerService {
	HashMap<String,Consumer> ConsumerCache=new HashMap<>();

	ConsumerRepository consumerRepository=new ConsumerRepository();
	@Override
	public int createConsumer(Consumer consumer) {
		// TODO Auto-generated method stub
		int consId=0;
		try {
			consumerRepository.createConsumer(consumer);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return consId;
	}
	@Override
	public List<Consumer> getAllConsumer() {
		// TODO Auto-generated method stub
		return consumerRepository.getDetailsConsumer();
	}
	
	
	@Override
	public HashMap<String, Consumer> display() {
		// TODO Auto-generated method stub
		for(Consumer cons:consumerRepository.getDetailsConsumer()) {
			ConsumerCache.put(cons.getConsName(), cons);
			
		}
		System.out.println(ConsumerCache);
		return ConsumerCache;
		
	}

	
}
