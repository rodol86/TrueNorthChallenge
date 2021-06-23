package com.example.restservice.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.restservice.repository.LoanRepository;
import com.example.restservice.service.LoanService;

@Component
public class AppInitializer {

	@Autowired
	LoanRepository loanRepository;
	
	@Autowired
	LoanService loanService;
	
	@SuppressWarnings("static-access")
	@PostConstruct
	private void initialLoad() {
		LoanGeneratonUtil LoanGeneratonUtil = new LoanGeneratonUtil();
		loanRepository.saveAll(LoanGeneratonUtil.getRandomLoans(new Long(10)));
	}
}
