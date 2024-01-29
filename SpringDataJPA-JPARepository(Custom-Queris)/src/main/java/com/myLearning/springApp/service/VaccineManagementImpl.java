package com.myLearning.springApp.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myLearning.springApp.bo.VaccineDetails;
import com.myLearning.springApp.dao.IVaccineRepo;

@Repository
public class VaccineManagementImpl implements IVaccineManagement {

	@Autowired
	private IVaccineRepo repo;

	@Override
	public List<VaccineDetails> searchVaccineByCompanyName(String name) {		
		return repo.searchVaccineByCompanyName(name);
	}

	@Override
	public List<VaccineDetails> searchVaccineDetailByCompanyName(String comp1, String comp2) {		
		return repo.searchVaccineDetailByCompanyName(comp1, comp2);
	}

	@Override
	public List<VaccineDetails> searchVaccineDetailByPriceIn(Integer price1, Integer price2) {		
		return repo.searchVaccineDetailByPriceIn(price1, price2);
	}
	
	@Override
	public List<VaccineDetails> searchVaccineDetailByPriceBetween(Integer price1, Integer price2) {		
		return repo.searchVaccineDetailByPriceIn(price1, price2);
	}

	@Override
	public List<Object[]> searchVaccineDetailByCompanyNameIn(String comp1, String comp2) {		
		return repo.searchVaccineDetailByCompanyNameIn(comp1, comp2);
	}

	@Override
	public List<String> searchVaccineDetailByPrice(Integer min, Integer max) {		
		return repo.searchVaccineDetailByPrice(min, max);
	}

	@Override
	public int updatePriceByVaccine(Integer newPrice, String vaccineName) {		
		return repo.updatePriceByVaccine(newPrice, vaccineName);
	}

	@Override
	public int deleteVaccineByPriceRange(Integer price, String vaccineName) {		
		return repo.deleteVaccineByPriceRange(price, vaccineName);
	}

	@Override
	public int insertVaccineDetails(String name, String company, int price) {	
		return repo.insertVaccineDetails(name, company, price);
	}

	@Override
	public int insertVaccineDetailsSQL(String name, String company, int price) {		
		return repo.insertVaccineDetailsSQL(name, company, price);
	}

	@Override
	public Date getTheSystemDateAndTime() {		
		return repo.getTheSystemDateAndTime();
	}

	
}
