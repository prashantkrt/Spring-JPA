package com.myLearning.springApp;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.myLearning.springApp.service.VaccineManagementImpl;

@SpringBootApplication
public class SpringDataJpa04Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringDataJpa04Application.class, args);

		VaccineManagementImpl service = context.getBean(VaccineManagementImpl.class);
		
		List<ResultView> view = service.fetchByName("ABC");
		view.forEach(i->System.out.println(i.getName()+" "+i.getCompany()));

		context.close();
	}

}
