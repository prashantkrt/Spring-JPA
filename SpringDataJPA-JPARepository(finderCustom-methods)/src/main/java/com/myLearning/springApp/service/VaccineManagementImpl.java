package com.myLearning.springApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.myLearning.springApp.bo.VaccineDetails;
import com.myLearning.springApp.dao.IVaccineRepo;

@Repository
public class VaccineManagementImpl implements IVaccineManagement {

	@Autowired
	private IVaccineRepo repo;

	@Override
	public List<VaccineDetails> searchByName(String companyName) {
		return repo.findByName(companyName);
	}

	@Override
	public List<VaccineDetails> searchByCompany(String companyName) {
		return repo.findByCompany(companyName);
	}

	@Override
	public List<VaccineDetails> searchByPrice(Integer price) {
		return repo.findByPrice(price);
	}

	@Override
	public Optional<VaccineDetails> searchByID(Long id) {
		return repo.findById(id);
	}

	@Override
	public List<VaccineDetails> searchByNameIs(String name) {
		return repo.findByNameIs(name);
	}

	@Override
	public List<VaccineDetails> searchByNameOrCompany(String name, String company) {
		return repo.findByNameOrCompany(name, company);
	}

	@Override
	public List<VaccineDetails> searchByNameAndCompany(String name, String company) {
		return repo.findByNameAndCompany(name, company);
	}

	@Override
	public List<VaccineDetails> searchByGreaterThan(Integer price) {
		return repo.findByPriceGreaterThan(price);
	}

	@Override
	public List<VaccineDetails> searchByGreaterThanEqual(Integer price) {
		return repo.findByPriceGreaterThanEqual(price);
	}

	@Override
	public List<VaccineDetails> searchByLessThan(Integer price) {
		return repo.findByPriceLessThan(price);
	}

	@Override
	public List<VaccineDetails> searchByLessThanEqual(Integer price) {		
		return repo.findByPriceLessThanEqual(price);
	}

	@Override
	public List<VaccineDetails> searchByPriceBetween(Integer price1,Integer price2) {		
		return repo.findByPriceBetween(price1, price2);
	}

	@Override
	public List<VaccineDetails> searchByPriceAfter(Integer price) {		
		return repo.findByPriceAfter(price);
	}

	@Override
	public List<VaccineDetails> searchByPriceBefore(Integer price) {		
		return  repo.findByPriceBefore(price);
	}

	@Override
	public List<VaccineDetails> searchByNameIsNull() {		
		return repo.findByNameNull();
	}

}
