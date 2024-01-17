package com.myLearning.springApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.myLearning.springApp.bo.VaccineDetails;
import com.myLearning.springApp.service.VaccineManagementImpl;

@SpringBootApplication
public class SpringDataJpa03Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringDataJpa03Application.class, args);
		
		VaccineManagementImpl vm = context.getBean(VaccineManagementImpl.class);
		System.out.println(vm.registerVaccineDetails(new VaccineDetails(6L, "KKR", "CCTY", 183)));

		List<VaccineDetails> list = new ArrayList<>();
		list.add(new VaccineDetails(70L, "VBRYT1", "OPUSI", 1675));
		list.add(new VaccineDetails(71L, "VBRYT2", "OPUSII", 1500));
		list.add(new VaccineDetails(72L, "VBRYT3", "OPUSIII", 1970));
		list.add(new VaccineDetails(73L, "VBRYT4", "OPUSIII", 2670));
		
		List<VaccineDetails> list1 = Arrays.asList(new VaccineDetails(7L, "VBRYT", "OPUS", 1670),
				new VaccineDetails(8L, "VBIA", "UIO", 193));
		List<VaccineDetails> list2 = List.of(new VaccineDetails(9L, "VBRYT1", "OPUS", 1070),
				new VaccineDetails(10L, "VBIA2", "UIO", 993));
		
		vm.registerMultipleVaccineDetails(list1);
		vm.registerMultipleVaccineDetails(list2);
		vm.registerMultipleVaccineDetails(list);		
		
		
		System.out.println("Number of vaccines in DB "+vm.countEntries());
		System.out.println("vaccine availibility in DB "+vm.checkVaccineAvailability(new VaccineDetails(70L, "VBRYT1", "OPUSI", 1675)));
		
		List<VaccineDetails> vaccineList = (List<VaccineDetails>) vm.getAllVaccines();
		vaccineList.forEach(n->System.out.println(n));
		
		
		List<VaccineDetails> vaccineLists = (List<VaccineDetails>) vm.getAllVaccinesByIds(List.of(8L,9L));
		vaccineLists.forEach(n->System.out.println(n));
		
		
		context.close();
	}

}
