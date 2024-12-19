package org.jsp.sms.repository;

import java.util.Optional;

import org.jsp.sms.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
public interface StudentRepository extends JpaRepository<Student, Integer> 
{
	Optional<Student> findByEmail(String email);
	Optional<Student> findByPhone(long phone);
	Optional<Student> findByEmailAndPassword(String email, String password);
	Optional<Student> findStudentByName(String name);

}
