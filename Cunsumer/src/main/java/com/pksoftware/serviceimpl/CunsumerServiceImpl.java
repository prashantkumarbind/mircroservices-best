package com.pksoftware.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pksoftware.dao.ConsumerDao;
import com.pksoftware.entity.Cunsumer;
import com.pksoftware.service.ConsumerService;

@Component
public class CunsumerServiceImpl implements ConsumerService{

	@Autowired
	ConsumerDao consumerDao;
	
	@Override
	public Cunsumer insert(Cunsumer cunsumer) {
		   Cunsumer cunsumer2 = consumerDao.save(cunsumer);
		   return cunsumer2;
	}

	@Override
	public List<Cunsumer> select() {
		   List<Cunsumer> list = consumerDao.findAll();
		return list;
	}

	@Override
	public Cunsumer update(Cunsumer cunsumer) {
		   Cunsumer cum = null;
		   Optional<Cunsumer> opt = consumerDao.findById(cunsumer.getPin());
		   if(opt.isPresent())
		   {
			     cum = consumerDao.save(cunsumer);
		   }
		   return cum;
		   
	}

	@Override
	public String delete(int accountNumber) {
		   String message="not find";	
		   Optional<Cunsumer> opt = consumerDao.findById(accountNumber);
		   if(opt.isPresent())
		   {
			   consumerDao.deleteById(accountNumber);
			   message="successfull delete";
		   }
		   return message;
	}

	@Override
	public Cunsumer getByAccountNumber(int accountNumber) {
		    Cunsumer cunsumer = null;
			Optional<Cunsumer> opt = consumerDao.findById(accountNumber);
			if(opt.isPresent())
			{
				 cunsumer = opt.get();
			}
			return cunsumer;
	}

}
