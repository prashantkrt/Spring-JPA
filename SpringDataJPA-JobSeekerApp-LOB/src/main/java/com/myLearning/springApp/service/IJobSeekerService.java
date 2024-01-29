package com.myLearning.springApp.service;

import java.util.List;
import java.util.Optional;

import com.myLearning.springApp.bo.JobSeeker;

public interface IJobSeekerService {
	
	public String registerJobSeeker(JobSeeker seeker);
	
	public List<JobSeeker> getAllJobSeeker();
	
	public Optional<JobSeeker> getAllById(Integer id);

}
