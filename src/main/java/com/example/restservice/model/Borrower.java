package com.example.restservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@SuppressWarnings("serial")
@Embeddable
public class Borrower implements Serializable{

	@Column
	private String name;
	
	@Column
	private Integer age;
	
	@Column
	private Double annualIncome;
	
	@Column
	private Boolean delinquentDebt;
	
	@Column
	private Double annualDebt;
	
	@Column
	private Integer creditHistory;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(Double annualIncome) {
		this.annualIncome = annualIncome;
	}

	public Boolean getDelinquentDebt() {
		return delinquentDebt;
	}

	public void setDelinquentDebt(Boolean delinquentDebt) {
		this.delinquentDebt = delinquentDebt;
	}

	public Double getAnnualDebt() {
		return annualDebt;
	}

	public void setAnnualDebt(Double annualDebt) {
		this.annualDebt = annualDebt;
	}

	public Integer getCreditHistory() {
		return creditHistory;
	}

	public void setCreditHistory(Integer creditHistory) {
		this.creditHistory = creditHistory;
	}

	   public String toString() {
	        Gson gson = new GsonBuilder().setPrettyPrinting().create();
	        return gson.toJson(this);
	    }
}