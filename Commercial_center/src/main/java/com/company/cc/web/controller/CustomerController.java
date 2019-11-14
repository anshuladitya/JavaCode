package com.company.cc.web.controller;


import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.cc.web.model.CustomerDto;
import com.company.cc.web.service.CustomerService;

@RequestMapping("/api/v2/customer")
@RestController
public class CustomerController {

    CustomerService customerService;
    CustomerDto customer;

    CustomerController(CustomerService customerService){
        this.customerService = customerService;
        customer = new CustomerDto();
    }

    @GetMapping({"/createCustomer"})
    public ResponseEntity<CustomerDto>  createCustomer(@RequestParam String custName,@RequestParam String custOccupation,@RequestParam int age){
    	customer.setCustomerName(custName);
    	customer.setOccupation(custOccupation);
    	customer.setAge(age);
        return new ResponseEntity<>(customerService.createCustomer(customer), HttpStatus.OK);
    }
    
    @GetMapping({"/customerDetails"})
    public ResponseEntity<CustomerDto>  getCustomer(@RequestParam int custId){
    	customer.setCustId(custId);
        return new ResponseEntity<>(customerService.getCustomerById(customer), HttpStatus.OK);
    }

    @GetMapping({"/customerList"})
    public ResponseEntity<List<CustomerDto>> getCustomerList(){
        return new ResponseEntity<>(customerService.getCustomerList(), HttpStatus.OK);
    }
}
