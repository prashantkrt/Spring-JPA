package com.myLearning.springApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myLearning.springApp.bo.JobSeeker;

public interface IJobSeekerDao extends JpaRepository<JobSeeker, Integer>{

}
