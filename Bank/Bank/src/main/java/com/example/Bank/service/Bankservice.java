package com.example.Bank.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Bank.model.Bankaccount;

import com.example.Bank.repository.BRepository;

@Service
public class Bankservice {
	 @Autowired
	private BRepository Brepo;
	 



	public Bankaccount createaccount(Bankaccount bankaccount) {
		// TODO Auto-generated method stub
		return Brepo.save(bankaccount);
	}



	public List<Bankaccount> getallstudent() {
		// TODO Auto-generated method stub
		return Brepo.findAll();
	}



	public Bankaccount getaccountbyid(long id) {
		// TODO Auto-generated method stub
		return Brepo.findById(id).orElse(null);
	}



	public Boolean deletebyid(long id) {
		// TODO Auto-generated method stub
		if(Brepo.existsById(id)) {
			Brepo.deleteById(id);
			return true;
		}
		return false;
	}



	public Bankaccount deposit(long id, double amount) {
		// TODO Auto-generated method stub
//		if(amount <=0) {
//			Bankaccount bankaccount=getaccountbyid(id);
//			bankaccount.setBalance(bankaccount.getBalance()+amount);
//			Brepo.save(bankaccount);
//			Trepo.save(new Transaction(null,id,amount,"deposit"));
//			return bankaccount;
//		}else {
//			return null;
		
//		}
		Bankaccount acc=getaccountbyid(id);
		acc.setBalance(acc.getBalance()+amount);
		return Brepo.save(acc);
	}



	public Bankaccount withdraw(long id, double amount) {
		// TODO Auto-generated method stub
	     Bankaccount acc=getaccountbyid(id);
	     if(acc.getBalance()<amount)throw new RuntimeException("insufficient balance");
	     acc.setBalance(acc.getBalance()-amount);
	     return Brepo.save(acc);
	}



	




	

      

	}





	
	


