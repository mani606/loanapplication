package com.user.demo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.demo.model.Loan;
import com.user.demo.repository.LoanRepository;


@Service
public class LoanServiceImpl implements LoanService {
	private final LoanRepository repository;
	 @Autowired
	    public LoanServiceImpl(final LoanRepository repository) {
	        this.repository = repository;
	    }


	@Override
	public List<Loan> getList() {
		// TODO Auto-generated method stub
		return repository.findAll();	}

	@Override
    public Loan getLoan(@Valid final Integer id) {
        return getList().get(id-1);
    }
	
		@Override
		public Loan createLoan(Loan loan) {
			// TODO Auto-generated method stub
			return null;
		}


		


	    
	


}
