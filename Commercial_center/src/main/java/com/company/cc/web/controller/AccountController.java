package com.company.cc.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.cc.web.model.AccountDto;
import com.company.cc.web.service.AccountService;

@RequestMapping("/api/v2/account")
@RestController
public class AccountController {
	AccountService accountService;
	AccountDto account;

	AccountController(AccountService accountService) {
		this.accountService = accountService;
		account = new AccountDto();
	}
	
	@GetMapping({"/createAccount"})
	public ResponseEntity<AccountDto> createAccount(@RequestParam String name,@RequestParam String accountType,@RequestParam String accountCurrency,@RequestParam float balance)
	{	
		account.setName(name);
		account.setAccountType(accountType);
		account.setCurrency(accountCurrency);
		account.setAccountBal(balance);
		return new ResponseEntity<AccountDto>(accountService.createAccount(account),HttpStatus.OK);
	}
	
	@GetMapping({"/accountDetails"})
	public ResponseEntity<AccountDto> getAccountDetails(@RequestParam int accountId)
	{
		account.setAccountNo(accountId);
		return new ResponseEntity<AccountDto>(accountService.getAccountDetails(account),HttpStatus.OK);
	}
	
	@GetMapping({"/accountList"})
	public ResponseEntity<List<AccountDto>> getAllAccountDetails()
	{
		return new ResponseEntity<List<AccountDto>>(accountService.getAllAccounts(),HttpStatus.OK);
	}
	
	@GetMapping({"/deleteAccount"})
	public ResponseEntity<String> deleteAccount(@RequestParam  int accountId)
	{
		account.setAccountNo(accountId);
		return new ResponseEntity<String>(accountService.deleteAccount(account),HttpStatus.OK);
	}
}
