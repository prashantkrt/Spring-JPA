package com.myLearning.springApp.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.myLearning.springApp.ResultView;
import com.myLearning.springApp.bo.VaccineDetails;

@Repository
public interface IVaccineRepo extends JpaRepository<VaccineDetails, Long>{
	
	public List<ResultView> findByName(String name);	

}
