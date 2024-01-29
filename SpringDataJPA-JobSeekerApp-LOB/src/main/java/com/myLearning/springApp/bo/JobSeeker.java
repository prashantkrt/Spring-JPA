package com.myLearning.springApp.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Job_Seeker")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="City")
	private String city;
	
	@Lob	
	@Column(length=65555)// if image size is bigger 
	private byte[] image;
	
	@Lob
	private char[] text;

	public JobSeeker(String name, String city, byte[] image, char[] text) {
		super();
		this.name = name;
		this.city = city;
		this.image = image;
		this.text = text;
	}	
	
}
