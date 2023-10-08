package com.pksoftware.entity;

import java.util.List;

public class Manage {

	Bank bank;
	Cunsumer cunsumer;
	Shop shop;
	List<Bank> bank1;
	List<Cunsumer> cunsumer1;
	List<Shop> shop1;
	
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	public Cunsumer getCunsumer() {
		return cunsumer;
	}
	public void setCunsumer(Cunsumer cunsumer) {
		this.cunsumer = cunsumer;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public String toString() {
		
		  return "\n **Manage** \n Bank::"+bank+"\n Shop::"+shop+"\n Cunsumer::"+cunsumer;
	}
//	
//	public void setBank(List<Bank> list) {
//		   	
//	}
	public List<Bank> getBank1() {
		return bank1;
	}
	public void setBank1(List<Bank> bank1) {
		this.bank1 = bank1;
	}
	public List<Cunsumer> getCunsumer1() {
		return cunsumer1;
	}
	public void setCunsumer1(List<Cunsumer> cunsumer1) {
		this.cunsumer1 = cunsumer1;
	}
	public List<Shop> getShop1() {
		return shop1;
	}
	public void setShop1(List<Shop> shop1) {
		this.shop1 = shop1;
	}
	
	
}
