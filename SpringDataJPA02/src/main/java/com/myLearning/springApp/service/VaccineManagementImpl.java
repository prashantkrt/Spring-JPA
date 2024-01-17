package com.myLearning.springApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myLearning.springApp.bo.VaccineDetails;
import com.myLearning.springApp.dao.IVaccineRepo;

@Component
public class VaccineManagementImpl implements IVaccineManagement {

	@Autowired
	private IVaccineRepo repo;
	
	@Override
	public String registerVaccineDetails(VaccineDetails vaccine) {		
		VaccineDetails v =repo.save(vaccine);
		return "Success entry for vaacine id ->"+v.getId();
	}
}
