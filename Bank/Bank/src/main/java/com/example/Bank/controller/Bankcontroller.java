package com.example.Bank.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bank.model.Bankaccount;

import com.example.Bank.service.Bankservice;

@RestController
@RequestMapping("/bank")
public class Bankcontroller {
	@Autowired
	private Bankservice service;
	
     @PostMapping("/addaccount")
     public ResponseEntity<Bankaccount> createaccount(RequestEntity<Bankaccount> requestEntity) {
    	 Bankaccount bankaccount=requestEntity.getBody();
    	 
    	 Bankaccount addaccount=service.createaccount(bankaccount);
    	 return ResponseEntity.status(HttpStatus.CREATED).body(addaccount);
    	 
    	 
     }
     @GetMapping("/accounts")
     public ResponseEntity<List<Bankaccount>> getallaccount(){
    	 return new ResponseEntity<>(service.getallstudent(),HttpStatus.OK);
     }
     
     @GetMapping("/account/{id}")
     public ResponseEntity<Bankaccount> getaccountbyid(@PathVariable long id){
    	 Bankaccount bankaccount=service.getaccountbyid(id);
    	 if(bankaccount !=null) {
    		 return new ResponseEntity<>(bankaccount,HttpStatus.OK);
    	 }else {
    		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	 }
    	 
     }
     
     @DeleteMapping("/account/{id}")
     public ResponseEntity<String> deletebyid(@PathVariable long id) {
    	 Boolean bankaccount=service.deletebyid(id);
    	 if(bankaccount) {
    		 return ResponseEntity.ok("deleted");
    	 }else {
    		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account can't found");
    	 }
     }
     
     @PostMapping("/deposit")
     public Bankaccount deposit(@RequestParam long id,@RequestParam double amount){
    	 return service.deposit(id,amount);
     }
     
     @PostMapping("/withdraw")
     public Bankaccount withdraw(@RequestParam long id,@RequestParam double amount){
    	 return service.withdraw(id,amount);
     }
    

    
}
