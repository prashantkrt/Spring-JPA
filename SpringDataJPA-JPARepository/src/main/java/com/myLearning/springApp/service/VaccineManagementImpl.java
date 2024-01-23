package com.myLearning.springApp.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;
import com.myLearning.springApp.bo.VaccineDetails;
import com.myLearning.springApp.dao.IVaccineRepo;

@Repository
public class VaccineManagementImpl implements IVaccineManagement {

	@Autowired
	private IVaccineRepo repo;	

	@Override
	public void registerVaccineDetail(VaccineDetails vaccine) {
		Example<VaccineDetails> example = Example.of(vaccine);
		if (repo.exists(example)) {
			repo.save(vaccine);
		}
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

	// **** PagingAndSorting methods ****
	@Override
	public Iterable<VaccineDetails> fetchDetails(boolean status, String... properties) {
		Sort sort = Sort.by(status ? Direction.ASC : Direction.DESC, properties);
		return repo.findAll(sort);
	}

	@Override
	public Page<VaccineDetails> fetchDetails(int pgNo, int pgSize, boolean status, String... properties) {

//	    PageRequest page = PageRequest.of(pgNo, pgSize);
		PageRequest pageable = PageRequest.of(pgNo, pgSize, status ? Direction.ASC : Direction.DESC, properties);
		Page<VaccineDetails> page = repo.findAll(pageable);
		List<VaccineDetails> list = page.getContent();
		list.forEach(i -> System.out.println(i));
		return page;
	}

	// *****JPA Repo methods****
	@Override
	public List<VaccineDetails> searchVaccineByGivenData(VaccineDetails vaccine, boolean status, String... properties) {
		Example<VaccineDetails> example = Example.of(vaccine);
		Sort sort = Sort.by(status ? Direction.ASC : Direction.DESC, properties);
		List<VaccineDetails> list = repo.findAll(example, sort);
		return list;
	}

	@Override
	public List<VaccineDetails> searchVaccineByGivenObject(VaccineDetails vaccine) {
		Example<VaccineDetails> example = Example.of(vaccine);
		List<VaccineDetails> list =repo.findAll(example);
		return list;
	}

	@Override
	public VaccineDetails searchVaccineById(Long id) {
		//repo.getById(id);
		//repo.getReferenceById(id);
		//return repo.getById(id);
		return repo.getReferenceById(id);
	}

	//deleteAll for jpa works in batch that is it works in single query
	// repo.deleteAllInBatch(); repo.deleteAllByIdInBatch(ids);
	@Override
	public void removeVaccinesById(Iterable<Long> ids) {
	 List<VaccineDetails>list= repo.findAllById(ids);
	 if(list.size()==((List<Long>)ids).size())		
	 repo.deleteAllByIdInBatch(ids);		
	}

}
