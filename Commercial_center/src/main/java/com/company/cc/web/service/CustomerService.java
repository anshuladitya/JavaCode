package com.company.cc.web.service;

import java.util.List;

import com.company.cc.web.model.CustomerDto;

public interface CustomerService {

	CustomerDto createCustomer(CustomerDto cust);
    CustomerDto getCustomerById(CustomerDto cust);
    
    List<CustomerDto> getCustomerList();
}
