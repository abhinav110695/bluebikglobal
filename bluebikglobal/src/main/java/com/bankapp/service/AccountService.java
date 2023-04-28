package com.bankapp.service;

import com.bankapp.exception.AccountException;
import com.bankapp.exception.UserException;
import com.bankapp.model.Account;

public interface AccountService {
	
	public Account addAccount(Account account) throws AccountException;
	
	public Account debit(Integer user_id,Long amount) throws AccountException,UserException;
	
	public Account credit(Integer user_id,Long amount) throws AccountException,UserException;
}
