package com.myLearning.springApp.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.myLearning.springApp.bo.VaccineDetails;
import com.myLearning.springApp.views.View;


@Repository
public interface IVaccineRepo extends JpaRepository<VaccineDetails, Long>{
	
	//lower bound
	public <T extends View> List<T> findByName(String name, Class<T> cls);
	
	

}
