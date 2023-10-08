package com.pksoftware.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.pksoftware.entity.Shop;
import com.pksoftware.service.ShopService;

@Controller
public class ShopController {

		@Autowired
		ShopService shopService;
	
		@ResponseBody
		@GetMapping("/testing/{name}")
		public String getName(@PathVariable String name) {
			   return "Your name::"+name;
		}
		
		@ResponseBody
		@PostMapping("/shop")
		public Shop getAllShop(@RequestBody Shop shop) {
			   Shop shopObj = shopService.insert(shop);
			   return shopObj;
		}
		
		@ResponseBody
		@GetMapping("/shop")
		public List<Shop> getShopObject(){
			   List<Shop> list = shopService.select();
			   return list;
		}
		
		@ResponseBody
		@PutMapping("/shop")
		public Shop updateData(@RequestBody Shop shop) {
			   Shop shopObj = shopService.update(shop);
			   return shopObj;
		}
		
		@ResponseBody
		@DeleteMapping("/shop/{id}")
		public String deleteData(@PathVariable int id) {
			   String message = shopService.delete(id);
			   return message;
		}
		
		@ResponseBody
		@GetMapping("/shop/{id}")
		public Shop getById(@PathVariable int id) {
			   Shop shop = shopService.getById(id);
			   return shop;
		}
}
