package com.pksoftware.feignservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.pksoftware.entity.Cunsumer;

@FeignClient(url="http://localhost:9592", value="cunsumer")
public interface CunsumerFeignClient {

		@GetMapping("/cunsumer/{id}")
		public Cunsumer getCunsumerDataById(int id);
		@GetMapping("/cunsumer")
		public List<Cunsumer> getCunsumerAllData();
}
