package com.pksoftware.feignservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.pksoftware.entity.Shop;


@FeignClient(url="http://localhost:9591", value="shop")
public interface ShopFeignClient {
	
		@GetMapping("/shop/{id}")
		public Shop getShopDataById(int id);
		@GetMapping("/shop")
		public List<Shop> getShopAllData();

		
}
