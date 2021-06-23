package com.example.restservice.exception;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/** Custome exception for the API
 * @author rodolfo
 *
 */
@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * No record found
	 * @param response
	 * @throws IOException
	 */
	@ExceptionHandler(NoRecordFoundException.class)
    public void springHandleNoRecordFound(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }
	
	/**
	 * The loanID informed for calculateLoanMetric is invalid
	 * @param response
	 * @throws IOException
	 */
	@ExceptionHandler(NoLoanIdException.class)
    public void springHandleNoLoanIdException(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }
}
