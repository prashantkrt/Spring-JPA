package com.myLearning.springApp.service;

import com.myLearning.springApp.bo.VaccineDetails;

public interface IVaccineManagement {

	//save
	public String registerVaccineDetails(VaccineDetails vaccine);

	//saveAll
	public Iterable<VaccineDetails> registerMultipleVaccineDetails(Iterable<VaccineDetails> vaccineList);

	//count
	public long countEntries();
	
	//exist or not
	public boolean checkVaccineAvailability(VaccineDetails vaccine);
	
	//findAll
	public Iterable<VaccineDetails> getAllVaccines();
	
	//findAllById
	public Iterable<VaccineDetails> getAllVaccinesByIds(Iterable<Long> idList);
	
	

}
