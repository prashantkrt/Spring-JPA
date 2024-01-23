package com.myLearning.springApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.myLearning.springApp.bo.VaccineDetails;

public interface IVaccineManagement {
	
	//save operations by CRUD
	public void registerVaccineDetail(VaccineDetails vaccine);	

	public Iterable<VaccineDetails> registerMultipleVaccineDetails(Iterable<VaccineDetails> vaccineList);	
	
	//find operations by CRUD
	public boolean checkVaccineAvailability(VaccineDetails vaccine);
	
	public long countEntries();	
	
	public Iterable<VaccineDetails> getAllVaccines();
	
	public Iterable<VaccineDetails> getAllVaccinesByIds(Iterable<Long> idList);	
	
	public Optional<VaccineDetails> getVaccineByIds(Long id);
	
	//Delete operations by CRUD
	public void removeVaccineById(Long id);
	
	public void removeVaccinesByIds(List<Long> ids);
	
	public void removeVaccineByObject(VaccineDetails vaccine);
	
	public void removeAllVaccines();
	
	//PagingAndSorting
	public Iterable<VaccineDetails> fetchDetails(boolean status, String... properties);
	
	public Page<VaccineDetails> fetchDetails(int pgNo, int pgSize, boolean status, String... properties);
	
	//--JPA--specific methods
	//find operations
	public List<VaccineDetails> searchVaccineByGivenData(VaccineDetails vaccine, boolean status, String...properties);
	
	public List<VaccineDetails> searchVaccineByGivenObject(VaccineDetails vaccine);
	
	public VaccineDetails searchVaccineById(Long id);
	
	//delete operations	
	public void removeVaccinesById(Iterable<Long> ids);
	

	
	
	
	
	
}
