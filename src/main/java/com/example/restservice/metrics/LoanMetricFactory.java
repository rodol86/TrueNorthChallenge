package com.example.restservice.metrics;

import org.springframework.stereotype.Service;

import com.example.restservice.metrics.impl.ConsumerLoanMetricCalculator;
import com.example.restservice.metrics.impl.StudentLoanMetricCalculator;
import com.example.restservice.model.Loan;

@Service
public class LoanMetricFactory {

	public static String LOAN_TYPE_STUDENT = "student";
	public static String LOAN_TYPE_CONSUMER = "consumer";

	public ILoanMetricCalculator getInstance(Loan loan) {
		
		if (loan.getType().equals(LOAN_TYPE_CONSUMER)) {
			return new ConsumerLoanMetricCalculator();

		}
		
		if (loan.getType().equals(LOAN_TYPE_STUDENT)) {
			return new StudentLoanMetricCalculator();
		}
		
		return null;
		
	}
	
	

}
