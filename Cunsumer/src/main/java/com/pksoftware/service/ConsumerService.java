package com.pksoftware.service;

import java.util.List;

import com.pksoftware.entity.Cunsumer;

public interface ConsumerService {

		Cunsumer insert(Cunsumer cunsumer);
		List<Cunsumer> select();
		Cunsumer update(Cunsumer cunsumer);
		String delete(int accountNumber);
		Cunsumer getByAccountNumber(int accountNumber);
}
