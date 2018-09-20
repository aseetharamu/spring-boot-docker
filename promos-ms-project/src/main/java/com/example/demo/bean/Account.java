package com.example.demo.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String name;
	
	@Column(columnDefinition = "created_on")
	private Date createdOn;
	
	@Column
	private float balance;
	
	public Account(){
		
	}	 
	
	public String getName() {
		return name;
	}
	public void setAccountName(String name) {
		this.name = name;
	}
	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public int getId() {
		return id;
	}
	public void setAccountId(int id) {
		this.id = id;
	}
	

}
