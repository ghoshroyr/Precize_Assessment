package com.rg.precizeassessment.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rg.precizeassessment.Exceptions.StudentNotFoundException;
import com.rg.precizeassessment.entities.Student;

public interface StudentService {

	public Student addStudent(Student student);
	public Optional<Student> getStudent(String name) throws StudentNotFoundException;
	public List<Student> getAllStudent();
	public Student updateStudent(Student student) throws StudentNotFoundException;
	public String deleteStudent(String name) throws StudentNotFoundException;
	public int getRank(String name) throws StudentNotFoundException;
}
