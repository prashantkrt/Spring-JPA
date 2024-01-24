package com.myLearning.springApp.service;

import java.util.List;
import java.util.Optional;

import com.myLearning.springApp.bo.VaccineDetails;

public interface IVaccineManagement {

	public List<VaccineDetails> searchByName(String name);

	public List<VaccineDetails> searchByCompany(String companyName);

	public List<VaccineDetails> searchByPrice(Integer price);

	public Optional<VaccineDetails> searchByID(Long id);

	public List<VaccineDetails> searchByNameIs(String name);

	public List<VaccineDetails> searchByNameOrCompany(String name, String company);

	public List<VaccineDetails> searchByNameAndCompany(String name, String company);

	public List<VaccineDetails> searchByGreaterThan(Integer price);

	public List<VaccineDetails> searchByGreaterThanEqual(Integer price);

	public List<VaccineDetails> searchByLessThan(Integer price);

	public List<VaccineDetails> searchByLessThanEqual(Integer price);

	public List<VaccineDetails> searchByPriceBetween(Integer price1,Integer price2);

	public List<VaccineDetails> searchByPriceAfter(Integer price);

	public List<VaccineDetails> searchByPriceBefore(Integer price);

	public List<VaccineDetails> searchByNameIsNull();

}
