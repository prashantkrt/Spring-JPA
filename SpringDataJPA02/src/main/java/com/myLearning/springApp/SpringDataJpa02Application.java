package com.myLearning.springApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.myLearning.springApp.bo.VaccineDetails;
import com.myLearning.springApp.dao.IVaccineRepo;
import com.myLearning.springApp.service.VaccineManagementImpl;

@SpringBootApplication
public class SpringDataJpa02Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringDataJpa02Application.class, args);

//		IVaccineRepo vaccine = context.getBean(IVaccineRepo.class);
//
//		VaccineDetails details = new VaccineDetails(4L, "Abcd", "xyx", 123);
//
//		vaccine.save(details);
		
		VaccineManagementImpl vm = context.getBean(VaccineManagementImpl.class);
		System.out.println(vm.registerVaccineDetails(new VaccineDetails(5L, "KKR", "CCTY", 183)));	
		

		context.close();
	}

}
