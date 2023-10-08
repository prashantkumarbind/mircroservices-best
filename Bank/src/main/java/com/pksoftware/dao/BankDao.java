package com.pksoftware.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pksoftware.entity.Bank;

public interface BankDao extends JpaRepository<Bank, Integer>{

}
