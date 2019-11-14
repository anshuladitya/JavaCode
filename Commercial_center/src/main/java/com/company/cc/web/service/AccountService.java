package com.company.cc.web.service;

import java.util.List;

import com.company.cc.web.model.AccountDto;

public interface AccountService {
	AccountDto getAccountDetails(AccountDto acct);
	List<AccountDto> getAllAccounts();
	String deleteAccount(AccountDto acct);	
	AccountDto createAccount(AccountDto acct);
}
