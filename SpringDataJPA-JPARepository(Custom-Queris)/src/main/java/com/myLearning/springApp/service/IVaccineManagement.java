package com.myLearning.springApp.service;

import java.util.Date;
import java.util.List;

import com.myLearning.springApp.bo.VaccineDetails;

public interface IVaccineManagement {
	
	public List<VaccineDetails> searchVaccineByCompanyName(String name);
	
	public List<VaccineDetails> searchVaccineDetailByCompanyName(String comp1,String comp2);
	
	public List<VaccineDetails> searchVaccineDetailByPriceIn(Integer price1,Integer price2);
	
	public List<VaccineDetails> searchVaccineDetailByPriceBetween(Integer price1,Integer price2);
	
	public List<String> searchVaccineDetailByPrice(Integer min,Integer max);
	
	public List<Object[]> searchVaccineDetailByCompanyNameIn(String comp1,String comp2);
	
	public int updatePriceByVaccine(Integer newPrice , String vaccineName);
	
	public int deleteVaccineByPriceRange(Integer price, String vaccineName);
	
	public int insertVaccineDetails(String name,String company,int price);
	
	public int insertVaccineDetailsSQL(String name,String company,int price);
	
	public Date getTheSystemDateAndTime();
	

}
