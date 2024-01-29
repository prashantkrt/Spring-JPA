package com.myLearning.springApp.dao;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.myLearning.springApp.bo.VaccineDetails;

import jakarta.transaction.Transactional;

@Repository
public interface IVaccineRepo extends JpaRepository<VaccineDetails, Long>{
	
	//both the methods are same
    @Query("FROM VaccineDetails WHERE company =:companyName")
	public List<VaccineDetails> searchVaccineByCompanyName(@Param("companyName") String name);
	
	@Query("FROM VaccineDetails WHERE company =:companyName")
	public List<VaccineDetails> searchVaccinesByCompanyName(String companyName);		
	
	@Query("FROM VaccineDetails WHERE company IN(:comp1,:comp2)")
	public List<VaccineDetails> searchVaccineDetailByCompanyName(String comp1,String comp2);
	
	@Query("FROM VaccineDetails WHERE price IN(:price1,:price2)")
	public List<VaccineDetails> searchVaccineDetailByPriceIn(Integer price1,Integer price2);	
	
	@Query("FROM VaccineDetails WHERE price Between :price1 AND :price2")
	public List<VaccineDetails> searchVaccineDetailByPriceBetween(Integer price1,Integer price2);	
	
	@Query("Select name, company from VaccineDetails where price Between :min AND :max")
	public List<String> searchVaccineDetailByPrice(Integer min,Integer max);	
	
	@Query("Select name, company from VaccineDetails where company IN(:comp1, :comp2)")
	public List<Object[]> searchVaccineDetailByCompanyNameIn(String comp1,String comp2);
	
	@Transactional //mandatory with non select operations
	@Modifying //mandatory
	@Query("Update VaccineDetails set price = :newPrice where name=:vaccineName")
	public int updatePriceByVaccine(Integer newPrice , String vaccineName);
	
	@Transactional
	@Modifying
	@Query("Delete from VaccineDetails where price=:price and name=:vaccineName")
	public int deleteVaccineByPriceRange(Integer price, String vaccineName);
	
	@Transactional
	@Modifying
	@Query("Insert into VaccineDetails(name,company,price) values(:name,:company,:price)")
	public int insertVaccineDetails(String name,String company,int price);
	
	//if working with native sql not with hql
	@Transactional
	@Modifying
	@Query(value ="Insert into Vaccine_Information(name,company,price) values(?,?,?)",nativeQuery = true)
	public int insertVaccineDetailsSQL(String name,String company,int price);	
	
	@Query(value ="Select * from Vaccine_Information where id=?1",nativeQuery = true)
	public int fetechById(Integer id);	
	
	@Query(value="Select now() from dual", nativeQuery = true)
	public Date getTheSystemDateAndTime();
	

}
