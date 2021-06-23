package com.example.restservice;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.restservice.model.Loan;
import com.example.restservice.model.LoanMetric;
import com.example.restservice.repository.LoanRepository;
import com.example.restservice.service.LoanService;

@RunWith(SpringRunner.class)
@SpringBootTest
class RestServiceApplicationTests {

	@Autowired
	LoanRepository loanRepository;
	
	@Autowired
	LoanService loanService;
		
	@Test
	void testGetLoan() {
		try {
			Loan loan = loanService.getLoan(3L);

			assertEquals(3L, loan.getLoanId());
		} catch (Exception e) {
			assertTrue(false);
			e.printStackTrace();
		}
	}
	
	@Test
	void testCalculateLoanMetricById() {
		try {
			LoanMetric LoanMetric = loanService.calculateLoanMetric(1L);
		} catch (Exception e) {
			assertTrue(false);
			e.printStackTrace();
		}
	}
	
	@Test
	void testGetMaxMonthlyPaymentLoan() {
		try {

			loanService.getMaxMonthlyPaymentLoan().toString();
		} catch (Exception e) {
			assertTrue(false);
			e.printStackTrace();
		}
	}
	
}
