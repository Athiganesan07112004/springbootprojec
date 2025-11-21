package com.example.Bank.model;



import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Component
@Entity
@Table(name = "bankaccount")

public class Bankaccount {
     @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   private String accountholdername;
   private String accounttype;
   private double balance;
   
public long getId() {
	return id;
}


public String getAccountholdername() {
	return accountholdername;
}

public void setAccountholdername(String accountholdername) {
	this.accountholdername = accountholdername;
}

public String getAccounttype() {
	return accounttype;
}

public void setAccounttype(String accounttype) {
	this.accounttype = accounttype;
}



public double getBalance() {
	return balance;
}


public void setBalance(double balance) {
	this.balance = balance;
}


public Bankaccount() {
	super();
}

public Bankaccount(long id, String accountholdername, String accounttype, double balance) {
	super();
	this.id = id;
	this.accountholdername = accountholdername;
	this.accounttype = accounttype;
	this.balance = balance;
}
   
}
