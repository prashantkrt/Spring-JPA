package com.myLearning.springApp.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Vaccine_Information")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String company;
	private Integer price;

	public VaccineDetails(String name, String company, Integer price) {
		super();
		this.name = name;
		this.company = company;
		this.price = price;
	}

}
