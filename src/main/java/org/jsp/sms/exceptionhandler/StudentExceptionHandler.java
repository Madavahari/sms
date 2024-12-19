package org.jsp.sms.exceptionhandler;

import org.jsp.sms.exceptionclasses.InvalidEmailException;
import org.jsp.sms.exceptionclasses.InvalidStudentIdException;
import org.jsp.sms.exceptionclasses.StudentNotFoundException;
import org.jsp.sms.responsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //to redirect all exception into this class
public class StudentExceptionHandler 
{
	@ExceptionHandler(InvalidEmailException.class)
	public ResponseEntity<?> invalidEmailExceptionHandler(InvalidEmailException e)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Invalid Email");
		structure.setBody("Unable to find Sudent");
		
		
		return new ResponseEntity<>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidStudentIdException.class)
	public ResponseEntity<?> invalidStudentIdExceptionHandler(InvalidStudentIdException e)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Invalid Studet Id");
		structure.setBody(e.getMessage());
		
		return new ResponseEntity<>(structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<?> studentNotFoundExceptionHandler(StudentNotFoundException e)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Invalid Studet Id");
		structure.setBody(e.getMessage());
		
		return new ResponseEntity<>(structure,HttpStatus.NOT_FOUND);
	}

}
