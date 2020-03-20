package com.user.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity

@Table
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "account_id")
	private Integer accountId;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "debit")
	private Float debit;

	@Column(name = "credit")
	private Float credit;
	
	@Column(name="balance")
	private Float balance;

	@ManyToOne(optional = false)
	@JoinColumn(name="id")
	private User user;

}
