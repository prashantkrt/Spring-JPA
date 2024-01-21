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

	@Override
	public Optional<VaccineDetails> getVaccineByIds(Long id) {
		return repo.findById(id);
	}

	@Override
	public void removeVaccineById(Long id) {
		Optional<VaccineDetails> vaccine = repo.findById(id);
		if (vaccine.isPresent()) {
			repo.deleteById(id);
			System.out.println("Vaccine is deleted");
		} else {
			System.out.println("Vaccine is not present to be deleted!!");
		}
	}

	@Override
	public void removeVaccinesByIds(List<Long> ids) {

		Iterable<VaccineDetails> list = repo.findAllById(ids);
		if (ids.size() == ((List<VaccineDetails>) list).size())// downcasting
		{
			System.out.println("Deleted all the id from the list");
		}
		repo.deleteAllById(ids);
		System.out.println("Number of object deleted " + ((List<VaccineDetails>) list).size());

	}

	@Override
	public void removeVaccineByObject(VaccineDetails vaccine) {

		Optional<VaccineDetails> vc = repo.findById(vaccine.getId());
		if (vc.isPresent()) {
			repo.delete(vaccine);
			System.out.println("Vaccine is deleted");
		} else
			System.out.println("Vaccine is not present");

	}

	@Override
	public void removeAllVaccines() {
		repo.deleteAll();
		System.out.println("All recorded deleted");

	}
}
