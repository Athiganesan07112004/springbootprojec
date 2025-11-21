package com.example.studentdet1.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.studentdet1.model.student;
import com.example.studentdet1.repo.studentrepo;
@Service
public class studentservice {
	@Autowired
	private studentrepo repo;

	public List<student> getAllstudent() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	

	public student getstudentbyid(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}



	public student updatestudent(int id,student Student) {
		// TODO Auto-generated method stub
		student s1=repo.findById(id).orElse(null);
		if(s1 !=null) {
			
			
			s1.setName(Student.getName());
			s1.setEmail(Student.getEmail());
			s1.setAge(Student.getAge());
			return repo.save(s1);
		}
		return null;
	}



	public boolean deletestudent(int id) {
		// TODO Auto-generated method stub
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return true;
		}
		return false;
	}



	public student addstudent(student Student) {
		// TODO Auto-generated method stub
		return repo.save(Student);
	}



	


	public student updatename(int id, student Student) {
		// TODO Auto-generated method stub
		Optional<student> sid = repo.findById(id);
		if(sid.isPresent()) {
			student sname=sid.get();
			sname.setName(Student.getName());
			return repo.save(sname);
		}
		return null;
	}








	public student updtaeemail(int id, student Student) {
		// TODO Auto-generated method stub
		Optional<student> sname= repo.findById(id);
		if(sname.isPresent()) {
			student sEmail=sname.get();
			sEmail.setEmail(Student.getEmail());
			return repo.save(sEmail);
		}
		return null;
	}



	public student updateEmailByName(String name, String email) {
		// TODO Auto-generated method stub
		   Optional<student> optionalStudent = repo.findByName(name).stream().findFirst();
	        if (optionalStudent.isPresent()) {
	            student Student = optionalStudent.get();
	            Student.setEmail(email);
	            return repo.save(Student);
	        }
		return null;
	}



	public boolean deletestudentbyname(String name) {
		// TODO Auto-generated method stub
		List<student> Student=repo.findByName(name);
		if(!Student.isEmpty()) {
			repo.deleteAll(Student);
			return true;
		}
		return false;
	}



	


	



	





	



	


	

	

}
