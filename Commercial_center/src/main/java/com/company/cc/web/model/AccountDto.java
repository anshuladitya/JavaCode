package com.company.cc.web.model;



import lombok.Builder;
import lombok.Data;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Builder
public class AccountDto {
	
	private int accountNo;
	private String name;
	private String accountType;
	private String currency;
	private float accountBal;
	
	public AccountDto()
	{
	}
	
	public AccountDto(int accountNo, String name, String accountType, String currency, float accountBal) {
		this.accountNo = accountNo;
		this.name = name;
		this.accountType = accountType;
		this.currency = currency;
		this.accountBal = accountBal;
	}

	public Integer getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public float getAccountBal() {
		return accountBal;
	}

	public void setAccountBal(float accountBal) {
		this.accountBal = accountBal;
	}	
}
