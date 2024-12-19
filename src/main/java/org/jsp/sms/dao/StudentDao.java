package org.jsp.sms.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.sms.entity.Student;
import org.jsp.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao
{
	@Autowired
	private StudentRepository repository;
	
	public Student saveStudent(Student student)
	{
		return repository.save(student);
		
	}

	public List<Student> findAllStudents() {

		return repository.findAll();
	}

	public Optional<Student> findStudentById(int id) {
	
		return repository.findById(id);
	}

	public void deleteStudentById(int id) 
	{
		repository.deleteById(id);
		
	}

	public Optional<Student> findStudentByEmail(String email) {
	
		return repository.findByEmail(email);
	}

	public Optional<Student> findStudentByPhone(long phone) {
		
		return repository.findByPhone(phone);
	}

	public Optional<Student> findStudentByEmailAndPassword(String email, String password) {
		
		return repository.findByEmailAndPassword(email,password);
	}

	public Optional<Student> findStudentByName(String name) {
		
		return repository.findStudentByName(name);
	}

	

}
