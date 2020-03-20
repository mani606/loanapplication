package com.user.demo.service;



import java.util.List;

import com.user.demo.model.Loan;



public interface LoanService {

    Loan createLoan(Loan loan);

    List<Loan> getList();

    Loan getLoan(Integer loanId);

}

