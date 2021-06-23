package com.example.restservice.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.model.Loan;
import com.example.restservice.model.LoanData;
import com.example.restservice.model.LoanMetric;
import com.example.restservice.service.LoanService;

@RestController("/loans")
public class LoanController {

	@Autowired
	LoanService loanService;
	
    /**
     * Endpoint for getting a loan by loanID
     * 
     * @param loanId
     * @return
     * @throws Exception
     */
    @GetMapping("/loans/loan/{loanId}")
    @ResponseStatus(HttpStatus.FOUND)
	public Loan getLoan(@PathVariable @Min(1) Long loanId) throws Exception {
		return loanService.getLoan(loanId);
	}

    /**
     * Endpoint for getting the metric by loanID
     * 
     * @param loanId
     * @return
     * @throws Exception
     */
    @GetMapping("/loans/loan/LoanMetric/{loanId}")
    @ResponseStatus(HttpStatus.OK)
	public LoanMetric calculateLoanMetric(@PathVariable @Min(1) Long loanId) throws Exception {
		return loanService.calculateLoanMetric(loanId);
	}

    
    /**
     * Endpoint for getting a loan with a Loan object
     * 
     * @param loan
     * @return
     * @throws Exception
     */
    @PostMapping("/loans/loan/LoanMetric")
    @ResponseStatus(HttpStatus.OK)
	public LoanMetric calculateLoanMetric(@RequestBody Loan loan) throws Exception {
    	return loanService.calculateLoanMetric(loan);
	}
    
    
    /**
     * Calculate de max monthly payment loan
     * 
     * @return
     */
    @GetMapping("/loans/MaxMonthlyPaymentLoan")
    @ResponseStatus(HttpStatus.OK)
	public LoanData getMaxMonthlyPaymentLoan() {
		return loanService.getMaxMonthlyPaymentLoan();
	}

}
