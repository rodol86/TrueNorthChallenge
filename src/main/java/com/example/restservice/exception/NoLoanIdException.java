package com.example.restservice.exception;

/** No record found exception
 * @author rodolfo
 *
 */
@SuppressWarnings("serial")
public class NoLoanIdException extends RuntimeException {

    public NoLoanIdException() {
        super("No loanId found. Please verify the information.");
    }


}
