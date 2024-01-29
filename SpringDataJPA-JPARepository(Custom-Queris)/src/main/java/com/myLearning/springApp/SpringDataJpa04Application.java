package com.myLearning.springApp;

import java.util.List;
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

		List<VaccineDetails> list = service.searchVaccineByCompanyName("ABCD");
		list.forEach(i->System.out.println(i));
		
		System.out.println();
		
		List<VaccineDetails> list2 = service.searchVaccineDetailByCompanyName("BVCX", "XYZW");
		list2.forEach(i->System.out.println(i));
		
		System.out.println();
		
		List<VaccineDetails> list3 = service.searchVaccineDetailByPriceIn(130, 200);
		list3.forEach(i->System.out.println(i));
		
		System.out.println();
		
		List<VaccineDetails> list4 = service.searchVaccineDetailByPriceBetween(130, 200);
		list4.forEach(i->System.out.println(i));		
		
		System.out.println();
		
		List<Object[]> list5 = service.searchVaccineDetailByCompanyNameIn("XYZW", "BVCX");
		
		for(Object[] obj : list5)
		{
			for(Object details : obj)
			{
				System.out.println(details);
			}
			System.out.println("-------------");
		}
		
		System.out.println();
		
		List<String> list6 = service.searchVaccineDetailByPrice(130, 230);
		list6.forEach(i->System.out.println(i));
		
		//number of rows changed
		System.out.println(service.updatePriceByVaccine(120, "ABC"));	 
		
		//number of rows deleted
		System.out.println(service.deleteVaccineByPriceRange(120, "XYZ"));
		
		//number of rows added
		System.out.println(service.insertVaccineDetails("ZXC", "PPK", 900));
		
		//number of rows added
		System.out.println(service.insertVaccineDetailsSQL("OOP", "OPPS", 700));
		
		System.out.println(service.getTheSystemDateAndTime());
		
		context.close();
	}

}
