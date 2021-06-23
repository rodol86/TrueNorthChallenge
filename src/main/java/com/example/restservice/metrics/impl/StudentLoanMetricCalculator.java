package com.example.restservice.metrics.impl;

import org.springframework.stereotype.Component;

import com.example.restservice.metrics.ILoanMetricCalculator;
import com.example.restservice.model.Loan;
import com.example.restservice.model.LoanMetric;

@Component
public class StudentLoanMetricCalculator implements ILoanMetricCalculator {

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

		return (0.8 * (loan.getRequestedAmount() * monthlyInterestRate)
				/ (1 - Math.pow((1 + monthlyInterestRate), ((-1) * loan.getTermMonths()))));
	}

	@Override
	public boolean isSupported(Loan loan) {
		// Validate if the loan type is supported
		if (loan.getBorrower().getAge() >= 18 && loan.getBorrower().getAge() <= 30) {
			return true;
		} else {
			return false;
		}
	}
}
