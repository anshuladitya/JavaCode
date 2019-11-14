package com.company.cc.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.cc.web.model.AccountDto;
import com.company.cc.web.service.AccountService;

@RequestMapping("/api/v3/account")
@RestController
public class AccountControllerXML {
	AccountService accountService;

	AccountControllerXML(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@PostMapping(path = "/createAccount",consumes = "application/xml",produces = "application/xml")	
	public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto acct)
	{	
		return new ResponseEntity<AccountDto>(accountService.createAccount(acct),HttpStatus.CREATED);
	}
	
	@PostMapping(path = "/accountDetails",consumes = "application/xml",produces = "application/xml")
	public ResponseEntity<AccountDto> getAccountDetails(@RequestBody AccountDto acct)
	{
		return new ResponseEntity<AccountDto>(accountService.getAccountDetails(acct),HttpStatus.OK);
	}
	
	@PostMapping(path = "/accountList",consumes = "application/xml",produces = "application/xml")
	public ResponseEntity<List<AccountDto>> getAllAccountDetails()
	{
		return new ResponseEntity<List<AccountDto>>(accountService.getAllAccounts(),HttpStatus.OK);
	}
	
	@PostMapping(path = "/deleteAccount",consumes = "application/xml",produces = "application/xml")
	public ResponseEntity<String> deleteAccount(@RequestBody  AccountDto acct)
	{
		return new ResponseEntity<String>(accountService.deleteAccount(acct),HttpStatus.OK);
	}
}
