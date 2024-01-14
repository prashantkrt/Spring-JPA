package com.myLearning.springApp.persistence;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
 * Respository Interface :
 * 1.) CRUDRepsitory Interface , all the methods which performs CRUD operations
 * 2.) JPARepository Interface , all the methods of CRUD + Pagination and Sorting 
 * 
*/
@Repository  //optional
public interface IStudentDao extends CrudRepository<StudentTable, Serializable> {

}
