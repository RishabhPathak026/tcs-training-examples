package com.tcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.beans.Account;
import com.tcs.dao.AccountRepository;
import com.tcs.exceptions.AccountNotFoundException;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository dao;
	
	@Override
	@Transactional
	public Account store(Account account) {
		// save method return type changes according to the Entity name you have mapped
		return dao.save(account);
	}

	@Override
	public Account fetchAccountById(int accountId) throws AccountNotFoundException {
		Account p = dao.findById(accountId).orElse(null);
		if(p == null) {
			throw new AccountNotFoundException("Account with an id "+accountId+" not found");
		}
	
		return p;
	}

	@Override
	@Transactional
	public void deleteAccountById(int accountId) throws AccountNotFoundException {
		Account p = fetchAccountById(accountId);
		dao.delete(p);
	}

	@Override
	@Transactional
	public Account updateAccountPassword(int accountId, String password) throws AccountNotFoundException {
		Account p = fetchAccountById(accountId);
		p.setPassword(password);
		return p;
	}

	@Override
	public List<Account> fetchAccounts() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public void transferAmount(int saccountId, int raccountId, int amt) throws AccountNotFoundException {
		
		Account p1 = fetchAccountById(saccountId);
		Account p2 = fetchAccountById(raccountId);
		
		if(p1.getBalance()<amt)
			throw new AccountNotFoundException("Insufficient Balance "+p1.getBalance());
		p1.setBalance(p1.getBalance() - amt);
		p2.setBalance(p2.getBalance() + amt);
	}

}
