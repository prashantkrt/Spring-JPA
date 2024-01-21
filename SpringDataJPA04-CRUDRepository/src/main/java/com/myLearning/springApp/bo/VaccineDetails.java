package com.myLearning.springApp.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//POJO(Plain old java object)

@Entity
@Table(name="Vaccine_Information")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineDetails {

	@Id
	private Long id;
	private String name;
	private String company;	
	private Integer price;
}
