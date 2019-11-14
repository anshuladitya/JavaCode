package com.company.cc.web.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.cc.web.model.CustomerDto;
import com.company.cc.web.service.CustomerService;

@RequestMapping("/api/v3/customer")
@RestController
public class CustomerControllerXML {
	
	CustomerService customerService;

	CustomerControllerXML(CustomerService customerService){
        this.customerService = customerService;
    }

	@PostMapping(path = "/createCustomer",consumes = "application/xml",produces = "application/xml")
    public ResponseEntity<CustomerDto>  createCustomer(@RequestBody CustomerDto cust){
        return new ResponseEntity<>(customerService.createCustomer(cust), HttpStatus.OK);
    }
	
    @PostMapping(path = "/customerDetails",consumes = "application/xml",produces = "application/xml")
    public ResponseEntity<CustomerDto>  getCustomer(@RequestBody CustomerDto cust){
        return new ResponseEntity<>(customerService.getCustomerById(cust), HttpStatus.OK);
    }

    @PostMapping(path = "/customerList",consumes = "application/xml",produces = "application/xml")
    public ResponseEntity<List<CustomerDto>> getCustomerList(){
        return new ResponseEntity<>(customerService.getCustomerList(), HttpStatus.OK);
    }
}
