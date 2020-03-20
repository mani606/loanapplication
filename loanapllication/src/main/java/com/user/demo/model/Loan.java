package com.user.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Loan {
	@Id
	@GeneratedValue
	private long id;
	public Loan(long id, long userid, long loanamount, int durationyears, long interestrate, Date loanstartdate,
			Date loanenddate, long emi) {
		super();
		this.id = id;
		this.userid = userid;
		this.loanamount = loanamount;
		this.durationyears = durationyears;
		this.interestrate = interestrate;
		this.loanstartdate = loanstartdate;
		this.loanenddate = loanenddate;
		this.emi = emi;
		
	}
	
	public Loan() {
		super();
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public long getLoanamount() {
		return loanamount;
	}
	public void setLoanamount(long loanamount) {
		this.loanamount = loanamount;
	}
	public int getDurationyears() {
		return durationyears;
	}
	public void setDurationyears(int durationyears) {
		this.durationyears = durationyears;
	}
	public long getInterestrate() {
		return interestrate;
	}
	public void setInterestrate(long interestrate) {
		this.interestrate = interestrate;
	}
	public Date getLoanstartdate() {
		return loanstartdate;
	}
	public void setLoanstartdate(Date loanstartdate) {
		this.loanstartdate = loanstartdate;
	}
	public Date getLoanenddate() {
		return loanenddate;
	}
	public void setLoanenddate(Date loanenddate) {
		this.loanenddate = loanenddate;
	}
	public long getEmi() {
		return emi;
	}
	public void setEmi(long emi) {
		this.emi = emi;
	}
	private long userid;
	private long loanamount;
	private int durationyears;
	private long interestrate;
	private Date loanstartdate;
	private Date loanenddate;
	private long emi;



   
}


	
  


