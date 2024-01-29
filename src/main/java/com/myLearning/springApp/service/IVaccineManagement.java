package com.myLearning.springApp.service;

import java.util.List;

import com.myLearning.springApp.views.View;

public interface IVaccineManagement {
	
	public <T extends View> List<T> findByName(String name, Class<T> cls);

	

}
