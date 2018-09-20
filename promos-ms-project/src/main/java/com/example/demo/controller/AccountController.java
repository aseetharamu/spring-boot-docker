package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.Receiver;
import com.example.demo.service.Sender;

@RequestMapping("/api")
@RestController
public class AccountController {
	
//	@Autowired
//	private AccountRepository repository;
//	
//	public void setAccountRepository(AccountRepository repository) {
//		this.repository = repository;
//	}
	
	private AccountRepository repository;
	
	public AccountController(AccountRepository repository) {
		this.repository = repository;
	}
//	@Autowired
//	private AccountService accountService;
	
	//path = "/get/xml", produces = MediaType.APPLICATION_XML_VALU
	@GetMapping(path="/accounts", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	
	public Iterable<Account> getAccounts() {
		//Account acct = new Account(104, "Affinity");
		//return String.format("The Account id is : %d", acct.getId());
		
		Iterable<Account> accounts = repository.findAll();
		
		
		return accounts;
		
	}
	
	@GetMapping("/rabbitSend")
	public String send() {
		System.out.println("---: sending AMQP message");
		try {
			Sender.send();
		} catch(Exception e) {
			System.err.println("***:" +e);
		}
		return "Sending Message";
	}
	
	@GetMapping("/rabbitRecv")
	public String receive() {
		System.out.println("---: receving AMQP message");
		try {
			Receiver.recv();
		} catch(Exception e) {
			System.err.println("***:" +e);
		}
		return "Received message";
	}
	

}
