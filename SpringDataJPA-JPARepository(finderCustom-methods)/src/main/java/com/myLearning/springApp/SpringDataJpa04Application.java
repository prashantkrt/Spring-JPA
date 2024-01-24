package com.myLearning.springApp;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.myLearning.springApp.bo.VaccineDetails;
import com.myLearning.springApp.service.VaccineManagementImpl;

@SpringBootApplication
public class SpringDataJpa04Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringDataJpa04Application.class, args);

		VaccineManagementImpl service = context.getBean(VaccineManagementImpl.class);

		List<VaccineDetails> list1 = service.searchByName("BVC");
		list1.forEach(i -> System.out.println(i));

		System.out.println("==========================");
		List<VaccineDetails> list2 = service.searchByCompany("ABCD");
		list2.forEach(i -> System.out.println(i));

		System.out.println("==========================");
		List<VaccineDetails> list3 = service.searchByPrice(230);
		list3.forEach(i -> System.out.println(i));

		System.out.println("==========================");
		Optional<VaccineDetails> value = service.searchByID(1L);

		if (value.isPresent())
			System.out.println(value.get());
		else {
			value.orElseThrow(() -> new IllegalArgumentException("Record not found"));
		}
		
		System.out.println("==========================");
		List<VaccineDetails> list5 = service.searchByNameIs("ABC");
		list5.forEach(i -> System.out.println(i));
		
		System.out.println("==========================");
		List<VaccineDetails> list6 = service.searchByNameOrCompany("Abc", "ABCD");
		list6.forEach(i -> System.out.println(i));
		
		System.out.println("==========================");
		List<VaccineDetails> list7 = service.searchByNameAndCompany("Abc", "ABCD");
		list7.forEach(i -> System.out.println(i));
		
		System.out.println("==========================");
		List<VaccineDetails> list8 = service.searchByGreaterThan(200);
		list8.forEach(i -> System.out.println(i));		
		

		context.close();
	}

}
