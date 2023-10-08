package com.pksoftware.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pksoftware.dao.BankDao;
import com.pksoftware.entity.Bank;
import com.pksoftware.service.BankService;

@Component
public class BankServiceImpl implements BankService{

	@Autowired
	BankDao bankDao;
	
	@Override
	public Bank insert(Bank bank) {
		   Bank bank2 = bankDao.save(bank); 
		   return bank2;
	}

	@Override
	public List<Bank> select() {
		List<Bank> list = bankDao.findAll();
		return list;
	}

	@Override
	public Bank update(Bank bank) {
		   Bank bank2=null;
		   Optional<Bank> opt = bankDao.findById(bank.getPin());
		   if(opt.isPresent())
		   {
			     bank2=bankDao.save(bank);
		   }
		return bank2;
	}

	@Override
	public String delte(int id) {
			String message = "Not Found";
			Optional<Bank> opt = bankDao.findById(id);
			if(opt.isPresent())
			{
				  bankDao.deleteById(id);
				  message="delete successfully";
			}
			return message;
	}

	@Override
	public Bank findByIdValue(int id) {
			Bank bank=null;
			Optional<Bank> opt = bankDao.findById(id);
			if(opt.isPresent())
			{
				  bank = opt.get();
			}
		return bank;
	}

}
