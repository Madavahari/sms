package org.jsp.sms.controller;

import java.util.List;

import org.jsp.sms.dto.AuthStd;
import org.jsp.sms.entity.Student;
import org.jsp.sms.responsestructure.ResponseStructure;
import org.jsp.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController 
{
	//@PM("/students")
	//@GM("/students")
	//@GM("/students/{id}")
	//@GM("/students/email/{email}")
	//@GM("/students/phone/{phone}")
	//@DM("/students/{id}")
	
	
	@Autowired
	private StudentService service;
	
	@PostMapping()
	public ResponseStructure<Student> saveStudent(@RequestBody Student student)
	{
		return service.saveStudent(student);
	}
	
	@GetMapping()
	public ResponseStructure<List<Student>> findAllStudents()
	{
		return service.findAllStudents();
	}
	
	@GetMapping("/{id}")
	public ResponseStructure<Student> findStudentById(@PathVariable int id)
	{
		return service.findStudentById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseStructure<String> deleteStudentById(@PathVariable int id)
	{
		return service.deleteStudentById(id);
	}
	
	@GetMapping("/email/{email}")
	public ResponseStructure<Student> findStudentByEmail(@PathVariable String email)
	{
		return service.findStudentByEmail(email);
	}
	
	@GetMapping("/phone/{phone}")
	public ResponseStructure<Student> findStudentByPhone(@PathVariable long phone)
	{
		return service.findStudentByPhone(phone);
	}
	
	@PostMapping("/login")
	public ResponseEntity<ResponseStructure<Student>> findStudentByEmailAndPassword(@RequestBody AuthStd auth)
	{
		return service.findStudentByEmailAndPassword(auth);
		
	}
	
	
	
	
	
	
	

}
