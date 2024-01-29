package com.myLearning.springApp.service;

import java.util.List;

import com.myLearning.springApp.ResultView;

public interface IVaccineManagement {

	public List<ResultView> fetchByName(String name);

}
