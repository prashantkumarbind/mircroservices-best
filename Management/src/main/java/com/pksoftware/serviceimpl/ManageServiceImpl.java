package com.pksoftware.serviceimpl;

import java.util.ArrayList;
import org.springframework.aot.hint.TypeReference;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.pksoftware.entity.Bank;
import com.pksoftware.entity.Cunsumer;
import com.pksoftware.entity.Manage;
import com.pksoftware.entity.Shop;
import com.pksoftware.feignservice.BankFeignClient;
import com.pksoftware.feignservice.CunsumerFeignClient;
import com.pksoftware.feignservice.ShopFeignClient;
import com.pksoftware.service.ManageService;

@Component
public class ManageServiceImpl implements ManageService{

	@Autowired
	RestTemplate restTemplate;
	
	
	@Autowired
	BankFeignClient bankFeignClient;
	
	@Autowired
	CunsumerFeignClient cunsumerFeignClient;
	
	@Autowired
	ShopFeignClient shopFeignClient;
	
	Manage manage;
	
	@Override
	public Manage selectById(int id) {
			
			ResponseEntity<Bank> bank = restTemplate.exchange("http://localhost:9593/bank/"+id, HttpMethod.GET, null, Bank.class);
			ResponseEntity<Shop> shop = restTemplate.exchange("http://localhost:9591/shop/"+id, HttpMethod.GET, null, Shop.class);
			ResponseEntity<Cunsumer> cunsumer = restTemplate.exchange("http://localhost:9592/cunsumer/"+id, HttpMethod.GET, null, Cunsumer.class);
			manage = new Manage();
			manage.setBank(bank.getBody());
			manage.setCunsumer(cunsumer.getBody());
			manage.setShop(shop.getBody());
			return manage;
	}

	@Override
	public List<Bank> selectAll() {
			ResponseEntity<List<Bank>> bank = restTemplate.exchange("http://localhost:9593/bank", HttpMethod.GET, null, new ParameterizedTypeReference<List<Bank>>() {}); 
			List<Bank> bb = bank.getBody();
			return bb;
	}

	@Override
	public Manage getAllConcept() {
		ResponseEntity<List<Bank>> bank = restTemplate.exchange("http://localhost:9593/bank", HttpMethod.GET, null, new ParameterizedTypeReference<List<Bank>>() {});
		ResponseEntity<List<Cunsumer>> cunsumer = restTemplate.exchange("http://localhost:9592/cunsumer", HttpMethod.GET, null, new ParameterizedTypeReference<List<Cunsumer>>() {});
		ResponseEntity<List<Shop>> shop = restTemplate.exchange("http://localhost:9591/shop", HttpMethod.GET, null, new ParameterizedTypeReference<List<Shop>>() {});
		Manage mm = new Manage();
		mm.setBank1(bank.getBody());
		mm.setShop1(shop.getBody());
		mm.setCunsumer1(cunsumer.getBody());
		return mm;
	}
		/* Below use of the feign client */
	
	@Override
	public Manage allClasseValueById(int id) {
			Bank bank = bankFeignClient.getBankDataById(id);
			Shop shop = shopFeignClient.getShopDataById(id);
			Cunsumer cunsumer = cunsumerFeignClient.getCunsumerDataById(id);
			Manage manage = new Manage();
			manage.setBank(bank);
			manage.setCunsumer(cunsumer);
			manage.setShop(shop);
			return manage;
	}

	@Override
	public Manage AllClassesAllValue() {
			List<Bank> banklist = bankFeignClient.getBankAllData();
			List<Shop> shoplist = shopFeignClient.getShopAllData();
			List<Cunsumer> cunsumerlist = cunsumerFeignClient.getCunsumerAllData();
			
			Manage manage = new Manage();
			manage.setBank1(banklist);
			manage.setShop1(shoplist);
			manage.setCunsumer1(cunsumerlist);
			return manage;
	}
	
	
	
}