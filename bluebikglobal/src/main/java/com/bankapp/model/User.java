package com.bankapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Integer user_id;
	
	@NotNull(message="First name cannot be null!")
	@Pattern(regexp = "^[A-Za-z]*")
	@Column(name = "name")
	private String name;
	
}
