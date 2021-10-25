package com.tcs.service;

import java.util.List;

import com.tcs.beans.Account;
import com.tcs.exceptions.AccountNotFoundException;

public interface AccountService {
	public Account store(Account account);
	public Account fetchAccountById(int accountId) throws AccountNotFoundException;
	public void deleteAccountById(int accountId) throws AccountNotFoundException;
	public Account updateAccountPassword(int accountId, String password) throws AccountNotFoundException;
	public List<Account> fetchAccounts();
	public void transferAmount(int saccountId, int raccountId,int amt) throws AccountNotFoundException;
}
