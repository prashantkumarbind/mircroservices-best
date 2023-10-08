package com.pksoftware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pksoftware.entity.Cunsumer;
import com.pksoftware.service.ConsumerService;


@Controller
public class ConsumerController {

		@Autowired
		ConsumerService consumerService;
	
		@ResponseBody
		@GetMapping("/testing/{name}")
		public String getName(@PathVariable String name) {
			   return name;
		}
		
		@ResponseBody
		@PostMapping("/cunsumer")
		public Cunsumer insertValue(@RequestBody Cunsumer cunsumer) {
			   Cunsumer cunsumer2 = consumerService.insert(cunsumer);
			   return cunsumer2;
		}
		
		@ResponseBody
		@GetMapping("/cunsumer")
		public List<Cunsumer> getAll(){
			   List<Cunsumer> list = consumerService.select();
			   return list;
		}
		
		@ResponseBody
		@DeleteMapping("/cunsumer/{id}")
		public String deleteData(@PathVariable int id) {
			   String message = consumerService.delete(id);
			   return message;
		}
		
		@ResponseBody
		@GetMapping("/cunsumer/{id}")
		public Cunsumer getById(@PathVariable int id) {
			   Cunsumer cunsumer = consumerService.getByAccountNumber(id);
			   return cunsumer;
		}
}
