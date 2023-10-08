package com.pksoftware.service;

import java.util.List;

import com.pksoftware.entity.Bank;
import com.pksoftware.entity.Manage;

public interface ManageService {

		Manage selectById(int id);
		List<Bank> selectAll();
		Manage getAllConcept();
		/* Below start of the all method for FeignClient concept */
		Manage allClasseValueById(int id);
		Manage AllClassesAllValue();
}
