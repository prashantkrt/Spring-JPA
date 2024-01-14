package com.myLearning.springApp.persistence;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity// representative of my actual table in db
@Data
@AllArgsConstructor
@Table(name="Student_table")
public class StudentTable {
	
	@Id
	@Column(name="ID")
	private Integer id;
	
	@Column(name="Age")
	private Integer age;
	
	@Column(name="City")
	private String city;
	
	@Column(name="Name")
	private String name;
	
	
	public StudentTable()
	{
		System.out.println("StudentTable bean is created ....");
	}

}
