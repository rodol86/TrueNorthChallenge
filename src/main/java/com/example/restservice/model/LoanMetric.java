package com.example.restservice.model;

import java.io.Serializable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@SuppressWarnings("serial")
public class LoanMetric implements Serializable {

	private Double monthlyInterestRate;
	private Double monthlyPayment;

	public LoanMetric(double monthlyInterestRate, double monthlyPayment) {
		this.monthlyInterestRate = monthlyInterestRate;
		this.monthlyPayment = monthlyPayment;
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

	   public String toString() {
	        Gson gson = new GsonBuilder().setPrettyPrinting().create();
	        return gson.toJson(this);
	    }
}