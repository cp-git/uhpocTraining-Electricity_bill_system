package com.cp.demo.service;

import java.util.HashMap;
import java.util.List;

import com.cp.demo.entity.Consumer;

public interface ConsumerService {
	
	int createConsumer(Consumer consumer);
	List<Consumer> getAllConsumer();
	HashMap<String,Consumer> display();

}
