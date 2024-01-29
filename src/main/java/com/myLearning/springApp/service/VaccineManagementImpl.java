package com.myLearning.springApp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.myLearning.springApp.dao.IVaccineRepo;
import com.myLearning.springApp.views.View;

@Repository
public class VaccineManagementImpl implements IVaccineManagement {

	@Autowired
	private IVaccineRepo repo;

	@Override
	public <T extends View> List<T> findByName(String name, Class<T> cls) {		
		return repo.findByName(name, cls);
	}

	
	
}
