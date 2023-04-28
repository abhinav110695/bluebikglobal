package com.bankapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.exception.AccountException;
import com.bankapp.exception.UserException;
import com.bankapp.model.Account;
import com.bankapp.model.User;
import com.bankapp.repository.AccountRepo;
import com.bankapp.repository.UserRepo;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private UserRepo ur;
	
	@Autowired
	private AccountRepo ar;
	
	@Override
	public Account addAccount(Account account) throws AccountException {
		Account a=ar.save(account);
		if(a!=null)
			return a;
		else 
			throw new AccountException("Account cannot be saved");
	}

	@Override
	public Account debit(Integer user_id, Long amount) throws AccountException,UserException {
		
		Optional<User> optUser=ur.findById(user_id);
		if(optUser.isPresent()) {
			Account ac=ar.findById(ar.accountNumber(user_id)).get();
			
			if(ac.getBalance()>=amount) {
				ac.setBalance(ac.getBalance()-amount);
				Account da=ar.save(ac);
				return da;
			}else throw new AccountException("Insufficient balance to debit");
		}else throw new UserException("User not found with user id"+ user_id);
		
	}

	@Override
	public Account credit(Integer user_id, Long amount) throws AccountException,UserException {
		Optional<User> optUser=ur.findById(user_id);
		if(optUser.isPresent()) {
			Account ac=ar.findById(ar.accountNumber(user_id)).get();
			
			if(ac.getBalance()+amount<=10000000) {
				ac.setBalance(ac.getBalance()+amount);
				Account ca=ar.save(ac);
				return ca;
			}else throw new AccountException("Account Balance cannot hold more than 10 Million");
		}else throw new UserException("User not found with user id"+ user_id);
		
	}

}
