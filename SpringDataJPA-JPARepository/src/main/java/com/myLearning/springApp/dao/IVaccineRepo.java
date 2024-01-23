package com.myLearning.springApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.myLearning.springApp.bo.VaccineDetails;

@Repository //optional
//all the crud + pagingandsorting methods included
public interface IVaccineRepo extends JpaRepository<VaccineDetails, Long>{

}
