package com.myLearning.springApp.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myLearning.springApp.bo.VaccineDetails;


@Repository //optional
public interface IVaccineRepo extends CrudRepository<VaccineDetails,Serializable>{

}
