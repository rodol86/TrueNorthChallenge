package com.example.restservice.metrics;

import com.example.restservice.model.Loan;
import com.example.restservice.model.LoanMetric;

public abstract class LoanMetricCalculator {
	
	Loan loan;
	/**
	 * Validates if a loan is supported to calculate metrics
	 * 
	 * @param loan
	 */
	public abstract boolean isSupported();

	/**
	 * Calculates the Loan Metric of a Loan entity
	 * 
	 * @param loan
	 */
	public abstract LoanMetric getLoanMetric();

	public LoanMetricCalculator(Loan loan) {
		super();
		this.loan = loan;
	}
	
	
	
}
