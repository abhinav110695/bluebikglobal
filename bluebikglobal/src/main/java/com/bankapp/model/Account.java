package com.bankapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.Data;

@Data
@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "account_id")
	private Integer account_id;
	
	@Min(value = 0)
	@Max(value = 10000000)
	@Column(name = "balance")
	private Long balance;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ac_us",referencedColumnName = "account_id")
	private List<User> user=new ArrayList<>();
	
}
