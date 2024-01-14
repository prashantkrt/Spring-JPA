package com.myLearning.springApp;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.myLearning.springApp.persistence.IStudentDao;
import com.myLearning.springApp.persistence.StudentTable;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(SpringDataJpaApplication.class, args);
		
/*	 Dao implementation will be given by Spring only	
*/		
		IStudentDao dao = context.getBean(IStudentDao.class);
		StudentTable st = new StudentTable();
		
		st.setId(21);
		st.setName("Dooga");
		st.setAge(27);
		st.setCity("Hazipur");
		
		dao.save(st);
		
		Optional<StudentTable> stu = dao.findById(20);
		System.out.println(stu);	
		
		
		((ConfigurableApplicationContext)context).close();
	}

}
