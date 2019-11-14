package com.company.cc.web.model;

import lombok.Builder;
import lombok.Data;


@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Builder

public class CustomerDto {

    private int custId;
    private String customerName;
    private String occupation;
    private int age;
    
    public CustomerDto()
    {
    }
    
	public CustomerDto(int custId, String customerName, String occupation, int age) {
		
		this.custId = custId;
		this.customerName = customerName;
		this.occupation = occupation;
		this.age = age;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
    
    
}