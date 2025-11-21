package com.example.studentdet1.repo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentdet1.model.student;
@Repository
public interface studentrepo extends JpaRepository<student,Integer>{

	 List<student> findByName(String name);
	

	

	

}
