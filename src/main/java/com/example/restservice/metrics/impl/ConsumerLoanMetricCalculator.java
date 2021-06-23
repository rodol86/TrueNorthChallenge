package com.example.restservice.metrics.impl;

import org.springframework.stereotype.Component;

import com.example.restservice.metrics.ILoanMetricCalculator;
import com.example.restservice.model.Loan;
import com.example.restservice.model.LoanMetric;

@Component
public class ConsumerLoanMetricCalculator implements ILoanMetricCalculator {

	@Override
	public LoanMetric getLoanMetric(Loan loan) {

		Double monthlyInterestRate = getMonthlyInterestRate(loan);

		Double monthlyPayment = getMonthlyPayment(loan, monthlyInterestRate);

		LoanMetric loanMetric = new LoanMetric(monthlyInterestRate, monthlyPayment);

		return loanMetric;
	}

	private Double getMonthlyInterestRate(Loan loan) {

		return ((loan.getAnnualInterest() / 12) / 100);
	}

	private Double getMonthlyPayment(Loan loan, Double monthlyInterestRate) {

		return ((loan.getRequestedAmount() * monthlyInterestRate)
				/ (1.00 - Math.pow((1.00 + monthlyInterestRate), ((-1.00) * loan.getTermMonths()))));
	}

	@Override
	public boolean isSupported(Loan loan) {
		// Validate if the loan type is supported
		if (loan.getBorrower().getAge() >= 18) {
			return true;
		} else {
			return false;
		}
	}

}
