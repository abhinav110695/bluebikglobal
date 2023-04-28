package com.bankapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.exception.AccountException;
import com.bankapp.exception.UserException;
import com.bankapp.model.Account;
import com.bankapp.service.AccountService;




@RestController
@RequestMapping("/bankapp")
public class AccountController {
	
	@Autowired
	private AccountService as;
	
	@PostMapping("/addaccount")
	public ResponseEntity<Account> registerUser(@Valid @RequestBody Account account) throws AccountException{
		return new ResponseEntity<>(as.addAccount(account),HttpStatus.CREATED);
	}
	
	@PutMapping("/credit/{user_id}/{amount}")
	public ResponseEntity<Account> credit(@PathVariable("user_id") Integer user_id,@PathVariable("amount") Long amount) throws AccountException,UserException{
		return new ResponseEntity<>(as.credit(user_id, amount),HttpStatus.OK);
	}
	
	@PutMapping("/debit/{user_id}/{amount}")
	public ResponseEntity<Account> debit(@PathVariable("user_id") Integer user_id,@PathVariable("amount") Long amount) throws AccountException,UserException{
		return new ResponseEntity<>(as.debit(user_id, amount),HttpStatus.OK);
	}
	
	
}
