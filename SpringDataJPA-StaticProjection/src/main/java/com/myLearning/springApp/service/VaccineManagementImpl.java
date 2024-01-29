package com.myLearning.springApp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.myLearning.springApp.ResultView;
import com.myLearning.springApp.dao.IVaccineRepo;

@Repository
public class VaccineManagementImpl implements IVaccineManagement {

	@Autowired
	private IVaccineRepo repo;

	@Override
	public List<ResultView> fetchByName(String name) {
		return repo.findByName(name);
	}
	
}
