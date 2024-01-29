package com.myLearning.springApp.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myLearning.springApp.bo.JobSeeker;
import com.myLearning.springApp.dao.IJobSeekerDao;

@Service
public class JobSeekerServiceImpl implements IJobSeekerService {
	
	@Autowired
	private IJobSeekerDao repo;

	@Override
	public String registerJobSeeker(JobSeeker seeker) {		
		return repo.save(seeker).toString();
	}

	@Override
	public List<JobSeeker> getAllJobSeeker() {		
		return repo.findAll();
	}

	@Override
	public Optional<JobSeeker> getAllById(Integer id) {
		Optional<JobSeeker> seeker = repo.findById(id);		
		return seeker;
	}

}
