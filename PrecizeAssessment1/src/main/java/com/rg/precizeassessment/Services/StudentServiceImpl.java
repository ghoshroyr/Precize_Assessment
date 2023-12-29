package com.rg.precizeassessment.Services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rg.precizeassessment.Exceptions.StudentNotFoundException;
import com.rg.precizeassessment.Repository.StudentRepository;
import com.rg.precizeassessment.entities.Student;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository studentdao;
	
	@Override
	public Student addStudent(Student student)
	{
		studentdao.save(student);
		return student;
	}
	@Override
	public Student updateStudent(Student student) throws StudentNotFoundException
	{
		if(!studentdao.existsById(student.getName()))
			throw new StudentNotFoundException("Student Not Found");
		studentdao.save(student);
		return student;
	}
	@Override
	public Optional<Student> getStudent(String name) throws StudentNotFoundException
	{
		if(!studentdao.existsById(name))
			throw new StudentNotFoundException("Student Not Found");
		return studentdao.findById(name);
	}
	@Override
	public List<Student> getAllStudent()
	{
		List<Student> list=new ArrayList();
		list.addAll(studentdao.findAll());
		return list;
	}
	@Override
	public String deleteStudent(String name) throws StudentNotFoundException
	{
		if(!studentdao.existsById(name))
			throw new StudentNotFoundException("Student Not Found");
		studentdao.deleteById(name);
		return name + "deleted Successfully";
	}
	@Override
	public int getRank(String name) throws StudentNotFoundException
	{
		if(!studentdao.existsById(name))
			throw new StudentNotFoundException("Student Not Found");
		List<Student> list=new ArrayList();
		Collections.sort(list,new Comparator<Student>() {
			public int compare(Student a, Student b) {
		        return a.getSATScore() - b.getSATScore();
			}
		});
		return list.indexOf(name)+1;
	}
}
