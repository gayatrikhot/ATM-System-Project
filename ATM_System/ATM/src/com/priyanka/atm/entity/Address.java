package com.priyanka.atm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address 
{
	@Id
	private Integer houseNo;
	private String houseName;
	private String pincode;
	
	public Integer getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(Integer houseNo) {
		this.houseNo = houseNo;
	}
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
}
