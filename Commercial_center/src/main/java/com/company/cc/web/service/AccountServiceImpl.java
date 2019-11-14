package com.company.cc.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import org.springframework.stereotype.Service;

import com.company.cc.web.model.AccountDto;

@Service
public class AccountServiceImpl implements AccountService {
	
	private Map<Integer,AccountDto> acctList;
	
	public AccountServiceImpl() {
		this.acctList = new HashMap<>();
	}
	
	@Override
	public AccountDto createAccount(AccountDto acct) {
		AccountDto ac = new AccountDto(new Random().nextInt(),acct.getName(),acct.getAccountType(),acct.getCurrency(),acct.getAccountBal());
		acctList.put(ac.getAccountNo(),ac);
		return ac;
	}
	@Override
	public AccountDto getAccountDetails(AccountDto acct) {
		if(acctList.containsKey(acct.getAccountNo()))
		{
			return acctList.get(acct.getAccountNo());
		}
		else
			return null;
	}
	
	@Override
	public List<AccountDto> getAllAccounts(){
		List<AccountDto> tempList = new ArrayList<AccountDto>();
		
		for(Entry<Integer, AccountDto> e : acctList.entrySet())
		{
			tempList.add(e.getValue());
		}
		return tempList;
	}

	@Override
	public String deleteAccount(AccountDto acct) {
		if(acctList.containsKey(acct.getAccountNo()))
		{
			acctList.remove(acct.getAccountNo());
			return "Account has been deleted succesfully";
		}
		else
			return "Account not found to be deleted";
	}
}
