package com.example.restservice.model;

import java.io.Serializable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@SuppressWarnings("serial")
public class LoanData implements Serializable {

	Loan loan;
	private Double monthlyInterestRate;
	private Double monthlyPayment;

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	public Double getMonthlyInterestRate() {
		return monthlyInterestRate;
	}

	public void setMonthlyInterestRate(Double monthlyInterestRate) {
		this.monthlyInterestRate = monthlyInterestRate;
	}

	public Double getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(Double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	public LoanData(Loan loan, LoanMetric loanMetric) {
		super();
		this.loan = loan;
		this.monthlyInterestRate = loanMetric.getMonthlyInterestRate();
		this.monthlyPayment = loanMetric.getMonthlyPayment();
	}

	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
