package com.user.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
	public class LoanDetails {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		
		private Integer loanDetailsId;

		
		private Float loanAmount;

		
		private Integer duration;

		
		private Float interestRate;

		
		private String status;

		@ManyToOne(optional = false)
		@JoinColumn(name = "id", referencedColumnName = "id")
		private Loan loan;
		
		@ManyToOne(optional = false)
		@JoinColumn(name = "id")
		private User user;

	}

