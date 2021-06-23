package com.example.restservice.exception;

/** No record found exception
 * @author rodolfo
 *
 */
@SuppressWarnings("serial")
public class NoRecordFoundException extends RuntimeException {

    public NoRecordFoundException() {
        super("No Loan found ");
    }


}
