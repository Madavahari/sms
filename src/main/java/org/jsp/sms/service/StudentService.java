package org.jsp.sms.service;

import java.util.List;
import java.util.Optional;

import org.jsp.sms.dao.StudentDao;
import org.jsp.sms.dto.AuthStd;
import org.jsp.sms.entity.Student;
import org.jsp.sms.exceptionclasses.InvalidEmailException;
import org.jsp.sms.exceptionclasses.InvalidStudentIdException;
import org.jsp.sms.exceptionclasses.StudentNotFoundException;
import org.jsp.sms.responsestructure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
public class StudentService 
{
	@Autowired
	private StudentDao dao;
	
	public ResponseStructure<Student> saveStudent(Student student)
	{
		student =dao.saveStudent(student);
		ResponseStructure<Student> structure=new ResponseStructure<>();
		structure.setHttpStatus(HttpStatus.CREATED.value());
		structure.setMessage("Student Saved Successfully");
		structure.setBody(student);
		return structure;
	}

	public ResponseStructure<List<Student>> findAllStudents() {
		List<Student> students= dao.findAllStudents();
		ResponseStructure<List<Student>> structure=new ResponseStructure<List<Student>>();
		if(students.isEmpty())
		{
//			structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
//			structure.setMessage("No Students Available In The Database");
//			structure.setBody(students);
//			return structure;
			throw new StudentNotFoundException("No Students Found");
		}
		structure.setHttpStatus(HttpStatus.OK.value());
		structure.setMessage("Student Found Successfully");
		structure.setBody(students);
		return structure;
	}

	public ResponseStructure<Student> findStudentById(int id) 
	{
		Optional<Student> optional=dao.findStudentById(id);
		ResponseStructure<Student> structure=new ResponseStructure<Student>();
		if(optional.isEmpty())
		{
			structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
			structure.setMessage("Invalid Id... Unable to delete");
			structure.setBody(null);
			return structure;
		}
		structure.setHttpStatus(HttpStatus.OK.value());
		structure.setMessage("Student found Successfully");
		structure.setBody(optional.get());
		return structure;
	}

	public ResponseStructure<String> deleteStudentById(int id)
	{
		Optional<Student> optional=dao.findStudentById(id);
		ResponseStructure<String> structure=new ResponseStructure<String>();
		if(optional.isEmpty())
		{
//			structure.setHttpStatus(HttpStatus.BAD_REQUEST.value());
//			structure.setMessage("Invalid Student Id.. unable to delete");
//			structure.setBody(null);
//			return structure;
			throw new InvalidStudentIdException("Invalid Student Id unable to delete");
		}
		dao.deleteStudentById(id);
		structure.setHttpStatus(HttpStatus.OK.value());
		structure.setMessage("Student Deleetd Successfully");
		structure.setBody(null);
		return structure;

	}

	public ResponseStructure<Student> findStudentByEmail(String email)
	{
		Optional<Student> optional=dao.findStudentByEmail(email);
		ResponseStructure<Student> structure=new ResponseStructure<Student>();
		if(optional.isEmpty())
		{
//			structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
//			structure.setMessage("No Student Found In database");
//			structure.setBody(null);
//			return structure;
			throw new InvalidEmailException("Invalid Email Unable to find Students");
		}
		structure.setHttpStatus(HttpStatus.OK.value());
		structure.setMessage("Student Found In database");
		structure.setBody(optional.get());
		return structure;
		
		
	}

	public ResponseStructure<Student> findStudentByPhone(long phone)
	{
		Optional<Student> optional=dao.findStudentByPhone(phone);
		ResponseStructure<Student> structure=new ResponseStructure<Student>();
		if(optional.isEmpty())
		{
			structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
			structure.setMessage("No Student Found In Database");
			structure.setBody(null);
			return structure;
		}
		structure.setHttpStatus(HttpStatus.OK.value());
		structure.setMessage("Student Found In Database");
		structure.setBody(optional.get());
		return structure;
	
	}

	public ResponseEntity<ResponseStructure<Student>> findStudentByEmailAndPassword(AuthStd auth) {
	    Optional<Student> optional = dao.findStudentByEmailAndPassword(auth.getEmail(),auth.getPassword());
	    ResponseStructure<Student> structure=new ResponseStructure<Student>();
	    if(optional.isEmpty())
	    {
//	    	structure.setHttpStatus(HttpStatus.BAD_REQUEST.value());
//			structure.setMessage("Invalid Crediantials...");
//			structure.setBody(null);
//			return new ResponseEntity(structure,HttpStatus.BAD_REQUEST);
	    	throw new InvalidEmailException("Invalid Email Unable to find Students");
	    }
	    structure.setHttpStatus(HttpStatus.OK.value());
		structure.setMessage("Login Successful");
		structure.setBody(optional.get());
		return new ResponseEntity(structure,HttpStatus.OK);
	}

	

	

}
