package com.pksoftware.service;

import java.util.List;

import com.pksoftware.entity.Shop;

public interface ShopService {

			Shop insert(Shop shop);
			List<Shop> select();
			Shop update(Shop shop);
			String delete(int id);
			Shop getById(int id);
}
