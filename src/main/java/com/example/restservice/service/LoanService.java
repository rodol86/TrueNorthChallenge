package com.example.restservice.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restservice.exception.NoRecordFoundException;
import com.example.restservice.metrics.LoanMetricFactory;
import com.example.restservice.model.Loan;
import com.example.restservice.model.LoanData;
import com.example.restservice.model.LoanMetric;
import com.example.restservice.repository.LoanRepository;
import com.example.restservice.util.LoanGeneratonUtil;

@Service
public class LoanService {

	@Autowired
	LoanMetricFactory loanMetricFactory;

	@Autowired
	LoanRepository loanRepository;
	
	/**
	 * Search the Loan by Id. If found return the Loan else throw NoRecordFoundException
	 * 
	 * @param id
	 * @return
	 * @throws NoRecordFoundException
	 */
	public Loan getLoan(Long id) throws NoRecordFoundException{
    	Optional<Loan> loan = loanRepository.findById(id);
    	
		if(!loan.isPresent()) {
			throw new NoRecordFoundException();
		}
		
		return LoanGeneratonUtil.createLoan(id);
	}

	/**
	 * Calculate the metric for a Loan
	 * 
	 * @param loan
	 * @return
	 */
	public LoanMetric calculateLoanMetric(Loan loan) {
		
		if(loan.getLoanId() != null && loan.getLoanId() < 1) {
			throw new NoRecordFoundException();
		}
		
		// Use the LoanMetricFactory based on the loan type
		LoanMetric loanMetric = loanMetricFactory.getInstance(loan).getLoanMetric(loan);

		return loanMetric;
	}

	/**
	 * Calculate the metric for a Loan
	 * 
	 * @param loan
	 * @return
	 */
	public LoanMetric calculateLoanMetric(Long loanId) {
		// Call getLoan(loanId)
		Loan loan = getLoan(loanId);

		return calculateLoanMetric(loan);
	}

	/**
	 * Calculate the max monthly payment loan
	 * 
	 * @param loan
	 * @return
	 */
	public LoanData getMaxMonthlyPaymentLoan() {
		List<Loan> allLoans = loanRepository.findAll();
		// get the loan with the max monthly payment
		
		/*
		 * I use max instead of a sort for better performance
		 */
		Optional<LoanData> MaxMonthlyPaymentLoan = allLoans
				.stream()
				.map(loan -> new LoanData(loan, calculateLoanMetric(loan)))
				.max(Comparator.comparing(LoanData::getMonthlyPayment));
		
		return MaxMonthlyPaymentLoan.get();
	}
		
}
