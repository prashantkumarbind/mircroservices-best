package com.pksoftware.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import com.pksoftware.entity.Manage;
import com.pksoftware.service.ManageService;

@Controller
public class ManageController {

	
		@Autowired
		ManageService manageService;
		
		@ResponseBody
		@GetMapping("/test/{name}")
		public String getName(@PathVariable String name) {
			   return "name::"+name;
		}
		

		@ResponseBody
		@GetMapping("/manage/{id}")
		public Manage getManage(@PathVariable int id) {
			   Manage manage = manageService.selectById(id);
			   return manage;
		}

		
		@ResponseBody
		@GetMapping("/manage")
		public Manage getAll(){
			   Manage manage = manageService.getAllConcept();
			   return  manage;
		}
		
		@ResponseBody
		@GetMapping("/managefeign/{id}")
		public Manage getAllClassesDataById(@PathVariable int id) {
			   Manage manage = manageService.allClasseValueById(id);
			   return manage;
		}
		
		@ResponseBody
		@GetMapping("/manage-feign-all-classes-value")
		public Manage getAllValueAllClasses() {
			   Manage manage = manageService.AllClassesAllValue();
			   return manage;
		}
}
