package com.myLearning.springApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.myLearning.springApp.bo.JobSeeker;
import com.myLearning.springApp.service.JobSeekerServiceImpl;

@SpringBootApplication
public class JobSeekerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(JobSeekerApplication.class, args);

		JobSeekerServiceImpl service = context.getBean(JobSeekerServiceImpl.class);

		InputStream input = null;
		FileReader reader = null;
		byte[] image = null;
		char[] text = null;
		try {
			input = new FileInputStream("/Users/prashantkumartiwary/Downloads/pink.jpeg");
			image = new byte[input.available()];// defines the size of image
			input.read(image);

			File file = new File("/Users/prashantkumartiwary/Downloads/mytext3.txt");
			reader = new FileReader(file);
			text = new char[(int) file.length()];
			reader.read(text);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		JobSeeker seeker = new JobSeeker("Rohan", "Bangalore", image, text);
		System.out.println(service.registerJobSeeker(seeker));

		List<JobSeeker> list = service.getAllJobSeeker();
		list.forEach(i -> System.out.println(i));

		// **Data retrival part**

		Integer id = 1;
		Optional<JobSeeker> optional = service.getAllById(id);

		if (optional.isPresent()) {
			JobSeeker jobSeeker = optional.get();
			System.out.println(jobSeeker.getId() + " : " + jobSeeker.getName() + " : " + jobSeeker.getCity());
			try {
				OutputStream output = new FileOutputStream("/Users/prashantkumartiwary/Downloads/dummy.jpg");
				output.write(jobSeeker.getImage());
				output.flush();

				FileWriter writer = new FileWriter("/Users/prashantkumartiwary/Downloads/dummy.txt");
				writer.write(jobSeeker.getText());
				writer.flush();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// close all the resources
			}
		} else {
			System.out.println("Data not available");
		}

		context.close();
	}

}
