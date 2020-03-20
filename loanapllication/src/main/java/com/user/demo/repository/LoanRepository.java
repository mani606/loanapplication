package com.user.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.demo.model.Loan;


/**
 * Needed to use HSQLDB
 */
@Repository
public interface LoanRepository extends JpaRepository<Loan, String> {

}
