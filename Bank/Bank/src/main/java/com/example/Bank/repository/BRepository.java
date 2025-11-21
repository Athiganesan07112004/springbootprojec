package com.example.Bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Bank.model.Bankaccount;
@Repository
public interface BRepository extends JpaRepository<Bankaccount, Long>{

}
