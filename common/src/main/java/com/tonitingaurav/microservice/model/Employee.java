package com.tonitingaurav.microservice.model;


import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Employee {

	@Size(min = 6)
	@ApiModelProperty(value = "Employee unique user name", example = "tonitingaurav")
	private String userName;

	@NotEmpty
	@ApiModelProperty(value = "Employee first name", example = "Nitin")
	private String firstName;

	@NotEmpty
	@ApiModelProperty(value = "Employee last name", example = "Agrawal")
	private String lastName;

	@Past
	@JsonFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty(value = "Employee Date of birth", example = "1981-01-01")
	private Date dateOfBirth;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
