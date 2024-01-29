package com.myLearning.springApp;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.myLearning.springApp.service.VaccineManagementImpl;
import com.myLearning.springApp.views.ResultView1;
import com.myLearning.springApp.views.ResultView2;
import com.myLearning.springApp.views.ResultView3;


@SpringBootApplication
public class SpringDataJpa04Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringDataJpa04Application.class, args);

		VaccineManagementImpl service = context.getBean(VaccineManagementImpl.class);
		
		
		List<ResultView2> list = service.findByName("ABC", ResultView2.class);
		list.forEach(i->System.out.println(i.getName()+" "+i.getCompany()));		
		
		System.out.println("----------------------------------");
		List<ResultView1> list2 = service.findByName("ABC", ResultView1.class);
		list2.forEach(i->System.out.println(i.getName()+" "+i.getId()));
		
		System.out.println("----------------------------------");
		
		List<ResultView3> list3 = service.findByName("ABC", ResultView3.class);
		list3.forEach(i->System.out.println(i.getName()+" "+i.getPrice()));		
		

		context.close();
	}

}
