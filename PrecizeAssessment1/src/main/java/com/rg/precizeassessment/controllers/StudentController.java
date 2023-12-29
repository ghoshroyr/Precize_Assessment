package com.rg.precizeassessment.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rg.precizeassessment.Exceptions.StudentNotFoundException;
import com.rg.precizeassessment.Services.StudentServiceImpl;
import com.rg.precizeassessment.entities.Student;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentServiceImpl studentimpl;
	
	@PostMapping("/AddStudent")
	public ResponseEntity<Student> addStudent(@RequestBody Student student)
	{
		if(student.getName()=="")
			return new ResponseEntity("No Student",HttpStatus.NOT_FOUND);
		Student stud=studentimpl.addStudent(student);
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
	@GetMapping("/ViewAllStudent")
	public ResponseEntity<List<Student>> getAllStudent()
	{
		List<Student> stud_list=studentimpl.getAllStudent();
		if(stud_list.isEmpty())
			return new ResponseEntity("Student not found",HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Student>>(stud_list,HttpStatus.OK);
	}
	@GetMapping("ViewStudentByName/{name}")
	public Optional<Student> getStudent(@PathVariable("name") String Name) throws StudentNotFoundException
	{
		return studentimpl.getStudent(Name);
	}
	@GetMapping("/ViewRank/{name}")
	public int getRank(@PathVariable("name") String Name) throws StudentNotFoundException
	{
		return studentimpl.getRank(Name);
	}
	@PutMapping("/UpdateStudent")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) throws StudentNotFoundException
	{
		if(student==null)
			return new ResponseEntity("Enter the Student to be updated",HttpStatus.NOT_FOUND);
		return new ResponseEntity<Student>(studentimpl.updateStudent(student),HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("/DeleteStudent/{name}")
	public String deleteStudent(@PathVariable("name") String Name) throws StudentNotFoundException
	{
		return studentimpl.deleteStudent(Name);
	}
}
