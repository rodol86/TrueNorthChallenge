package com.example.restservice.exception;

/** No record found exception
 * @author rodolfo
 *
 */
@SuppressWarnings("serial")
public class InvalidLoanException extends RuntimeException {

    public InvalidLoanException() {
        super("Customer is no eligible for a loan.");
    }


}
