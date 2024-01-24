package com.myLearning.springApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.myLearning.springApp.bo.VaccineDetails;

@Repository
public interface IVaccineRepo extends JpaRepository<VaccineDetails, Long>{
	
	//findByProperty
	public List<VaccineDetails> findByName(String name);
	
	public List<VaccineDetails> findByCompany(String companyName);	
	
	public List<VaccineDetails> findByPrice(Integer price);
	
	// Is , Equals
	//findByFirstName , findByFirstNameIs , findByFirstNameEquals	
	public List<VaccineDetails> findByNameIs(String name);
	
	//or
	public List<VaccineDetails> findByNameOrCompany(String name,String company);
	
	//And
	public List<VaccineDetails> findByNameAndCompany(String name,String company);
	
	//GreaterThan 
	public List<VaccineDetails> findByPriceGreaterThan(Integer price);
	//GreaterThanEqual
	public List<VaccineDetails> findByPriceGreaterThanEqual(Integer price);
	//LessThan
	public List<VaccineDetails> findByPriceLessThan(Integer price);
	//LessThanEqual
	public List<VaccineDetails> findByPriceLessThanEqual(Integer price);	
	
	//Between
	public List<VaccineDetails> findByPriceBetween(Integer price1,Integer price2);
	
	//After
	public List<VaccineDetails> findByPriceAfter(Integer price);
	//Before
	public List<VaccineDetails> findByPriceBefore(Integer price);
	
	//IsNull
	//IsNull, Null
	public List<VaccineDetails> findByNameNull();
	
	//IsNotNull, NotNull
	List<VaccineDetails> findByNameIsNotNull();

	List<VaccineDetails> findByNameNotNull();
	

}
