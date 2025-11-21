package com.example.studentdet1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.studentdet1.model.student;
import com.example.studentdet1.service.studentservice;

@RestController
@RequestMapping("/student")
public class studentcontroller {
	@Autowired
	private studentservice service;
	@GetMapping("/all")
	public ResponseEntity<List<student>> getAllstudent(){
		return new ResponseEntity<>(service.getAllstudent(),HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<student> getstudent(@PathVariable int id){
		student Student=service.getstudentbyid(id);
		if(Student !=null) {
			return new ResponseEntity<>(Student,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
	} 
	@PutMapping("/{id}")
	public ResponseEntity<?> updatestudent(@PathVariable int id,RequestEntity<student> requestentity){
		student updated=service.updatestudent(id,requestentity.getBody());
		if(updated !=null) {
			return new ResponseEntity<>(updated,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletestudent(@PathVariable int id){
		boolean deleted =service.deletestudent(id);
		if(deleted) {
			return  ResponseEntity.ok("student deleted");
		}else {
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("cannot found ");
		}
	}
	@PostMapping("/add")
	public ResponseEntity<student> addstudent(RequestEntity<student> requestentity){
		student Student=requestentity.getBody();
		student addstuden=service.addstudent(Student);
		return ResponseEntity.status(HttpStatus.CREATED).body(addstuden);
		
	}
	@PutMapping("/{id}/name")
	public  ResponseEntity<?> updatename(@PathVariable int id,@RequestBody student Student){
		student name=service.updatename(id,Student);
		if(name !=null) {
			return new ResponseEntity<>(name,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/{id}/email")
	public ResponseEntity<?> updateemail(@PathVariable int id,@RequestBody student Student){
		student email=service.updtaeemail(id,Student);
		if(email !=null) {
			return new ResponseEntity<>(email,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	   @PutMapping("/{name}/ee")
	    public ResponseEntity<?> updateEmailByName(@PathVariable String name, @RequestBody student Student) {
	        student updated = service.updateEmailByName(name, Student.getEmail());  
	        if (updated != null) {
	            return new ResponseEntity<>(updated, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	   @DeleteMapping("name/{name}")
	   public ResponseEntity<String> deletestudentbyname(@PathVariable String name){
		   boolean deletename=service.deletestudentbyname(name);
		   if(deletename) {
			   return  ResponseEntity.ok("student deleted");
		   }else{
			   return ResponseEntity.status(HttpStatus.NOT_FOUND).body("student not found");
		   }
	   }

}
