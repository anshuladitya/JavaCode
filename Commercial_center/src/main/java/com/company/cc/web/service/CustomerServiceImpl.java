package com.company.cc.web.service;

import org.springframework.stereotype.Service;

import com.company.cc.web.model.CustomerDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

@Service
public class CustomerServiceImpl implements CustomerService {

	private Map<Integer,CustomerDto> custList;
	
	public CustomerServiceImpl() {
		this.custList = new HashMap<>();
	}

	@Override
	public CustomerDto createCustomer(CustomerDto cust) {
		CustomerDto c = new CustomerDto(new Random().nextInt(), cust.getCustomerName(), cust.getOccupation(),cust.getAge());
		custList.put(c.getCustId(), c);
		return c;
	}
	
	@Override
	public CustomerDto getCustomerById(CustomerDto cust) {
		//return CustomerDto.builder().custId(UUID.randomUUID()).customerName("Saurabh").occupation("Engineer").age(30)
			//	.build();
		if(custList.containsKey(cust.getCustId()))
			return custList.get(cust.getCustId());
		else
			return null;
	}

	@Override
	public List<CustomerDto> getCustomerList() {
		List<CustomerDto> tempCust = new ArrayList<>();
		for(Entry<Integer, CustomerDto> e : custList.entrySet())
		{
			tempCust.add(e.getValue());
		}
		return tempCust;
	}
}
