package org.jsp.sms.exceptionclasses;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidEmailException extends RuntimeException
{
	private String message;
	public InvalidEmailException(String message) {
		this.message=message;
	}
	@Override
	public String getMessage() {
		return this.message;
	}

	

}
