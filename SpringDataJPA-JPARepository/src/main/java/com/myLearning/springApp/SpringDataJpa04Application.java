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
		
//		service.registerVaccineDetail(new VaccineDetails("ABC","ABCD",230));
//		List<VaccineDetails> ls = Arrays.asList(new VaccineDetails("ABC","ABCD",230)
//				,new VaccineDetails("XYZ","XYZW",130),new VaccineDetails("BVC","BVCX",430));
//		service.registerMultipleVaccineDetails(ls);
		
		VaccineDetails vaccine = new VaccineDetails();
		VaccineDetails vaccine1 = new VaccineDetails("ABC","ABCD",230);
		
		List<VaccineDetails> list = service.searchVaccineByGivenData(vaccine1, true, "price","name");
		list.forEach(i->System.out.println(i));
		
		System.out.println(service.searchVaccineById(3L));
		context.close();
	}

}
