package org.jsp.sms.exceptionclasses;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StudentNotFoundException extends RuntimeException 
{
	private String message;

	@Override
	public String getMessage() {
		return this.message;
	}

	public StudentNotFoundException(String message) {
	
		this.message = message;
	}

	

}
