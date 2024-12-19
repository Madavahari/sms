package org.jsp.sms.exceptionclasses;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidStudentIdException extends RuntimeException
{
	private String message;

	@Override
	public String getMessage() {
		return this.message;
	}

	public InvalidStudentIdException(String message) {
	
		this.message = message;
	}
	
	

}
