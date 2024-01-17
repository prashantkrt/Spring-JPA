package com.myLearning.springApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.myLearning.springApp.bo.VaccineDetails;
import com.myLearning.springApp.dao.IVaccineRepo;

@Repository
public class VaccineManagementImpl implements IVaccineManagement {

	@Autowired
	private IVaccineRepo repo;

	@Override
	public String registerVaccineDetails(VaccineDetails vaccine) {
		VaccineDetails v = repo.save(vaccine);
		return "Success entry for vaacine id ->" + v.getId();
	}

	@Override
	public Iterable<VaccineDetails> registerMultipleVaccineDetails(Iterable<VaccineDetails> vaccineList) {
		Iterable<VaccineDetails> list = repo.saveAll(vaccineList);
		return list;
	}

	@Override
	public long countEntries() {		
		return repo.count();
	}

	@Override
	public boolean checkVaccineAvailability(VaccineDetails vaccine) {		
		return repo.existsById(vaccine.getId());
	}

	@Override
	public Iterable<VaccineDetails> getAllVaccines() {
		Iterable<VaccineDetails> list = repo.findAll();
		return list;
	}

	@Override
	public Iterable<VaccineDetails> getAllVaccinesByIds(Iterable<Long> idList) {
		return repo.findAllById(idList);
	}
	
}
