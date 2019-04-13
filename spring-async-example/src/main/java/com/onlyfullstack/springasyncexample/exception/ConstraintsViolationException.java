package com.onlyfullstack.springasyncexample.exception;

import com.onlyfullstack.springasyncexample.datatransferobject.ErrorDetails;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.stream.Collectors;


@ControllerAdvice
@RestController
public class ConstraintsViolationException extends ResponseEntityExceptionHandler {
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

		String errorMessage = ex.getBindingResult().getAllErrors().stream()
								.map(error -> error.getDefaultMessage())
								.collect(Collectors.joining(","));

		ErrorDetails errorDetails = new ErrorDetails(new Date(), "Constraints Validation Failed", errorMessage);
		
		return new ResponseEntity<Object>(errorDetails, HttpStatus.BAD_REQUEST);
	}
}